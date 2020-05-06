package com.kevindai.auth.security.utils;

import com.kevindai.auth.security.entity.LoginSecurityUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Slf4j
@Component
public class JwtTokenUtil {

    private static final String USER_NAME = Claims.SUBJECT;

    private static final String USER_ID = "userId";

    private static final String PERMS = "perms";

    private static final String CREATED = "created";

    private static final String AUTHORITIES = "authorities";

    private static final String SECRET = "kikatech";

    private static final String ISS = "KIKA";

    private static final long EXPIRE_TIME = 60 * 60 * 1000L;

    private static final long EXPIRE_TIME_WEEKLY = 60 * 60 * 24 * 7 * 1000L;

    @Value("${jwt.token.header}")
    private String tokenHeader;

    @Value("${jwt.token.prefix}")
    private String tokenPrefix;

    public static String generateToken(LoginSecurityUser userDetail, boolean rememberMe) {
        Map<String, Object> claims = new HashMap<>(4);
        claims.put(USER_ID, userDetail.getUserId());
        claims.put(USER_NAME, userDetail.getUsername());
        claims.put(PERMS, userDetail.getAuthorities());
        claims.put(CREATED, new Date());
        claims.put(AUTHORITIES, userDetail.getAuthorities());
        return generateToken(claims, rememberMe);
    }

    private static String generateToken(Map<String, Object> claims, boolean rememberMe) {
        long expiration = rememberMe ? EXPIRE_TIME_WEEKLY : EXPIRE_TIME;
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setIssuer(ISS)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return claims.getSubject();
    }

    public LoginSecurityUser getUserFromToken(HttpServletRequest request) {
        String token = getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            Claims claims = getClaimsFromToken(token);
            if (claims == null) {
                return null;
            }
            String username = claims.getSubject();
            if (username == null) {
                return null;
            }
            if (isTokenExpired(token)) {
                return null;
            }
            Object authors = claims.get(AUTHORITIES);
            Long userId = Long.parseLong(claims.get(USER_ID).toString());
            Set<String> perms = new HashSet<>();
            if (authors instanceof List) {
                for (Object object : (List) authors) {
                    perms.add(((Map) object).get("authority").toString());
                }
            }
            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(perms.toArray(new String[0]));
            if (validateToken(token, username)){
                return new LoginSecurityUser(userId, username, "", authorities);
            }
        }
        return null;
    }

    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    private static Boolean validateToken(String token, String username) {
        String userName = getUsernameFromToken(token);
        return (userName.equals(username) && !isTokenExpired(token));
    }

    private static Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        if (StringUtils.isNotEmpty(token)) {
            token = token.substring(tokenPrefix.length());
        }
        return token;
    }

}
