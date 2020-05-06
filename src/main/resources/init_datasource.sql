-- -------------------------------------------------------------
-- TablePlus 2.10(268)
--
-- https://tableplus.com/
--
-- Database: auth
-- Generation Time: 2020-05-06 11:22:16.0180
-- -------------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `menu_info`;
CREATE TABLE `menu_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '菜单名称',
  `path` varchar(128) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '前端跳转URL',
  `component` varchar(255) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '菜单组件',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父菜单ID',
  `icon` varchar(32) COLLATE utf8mb4_bin NOT NULL DEFAULT '',
  `sort` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '菜单类型(0: 目录; 1: 菜单; 2: 按钮)',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '删除标识(0: 未删除; 1: 已删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='菜单信息表';

DROP TABLE IF EXISTS `r_role_menu`;
CREATE TABLE `r_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色菜单关联表';

DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户角色关联表';

DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_desc` varchar(500) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '角色描述',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态:0、正常 1、异常',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '状态:0、未删除 1、已删除',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='角色信息表';

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL DEFAULT '' COMMENT '密码',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '状态:0、正常 1、异常',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户信息表';

INSERT INTO `menu_info` (`id`, `name`, `path`, `component`, `parent_id`, `icon`, `sort`, `type`, `gmt_create`, `gmt_modify`, `is_delete`) VALUES ('1', '首页', '/index', 'TEST', '0', '', '1', '0', '2020-05-05 17:58:57', '2020-05-05 18:07:18', '0');

INSERT INTO `r_role_menu` (`id`, `role_id`, `menu_id`) VALUES ('82', '1', '1');

INSERT INTO `r_user_role` (`id`, `user_id`, `role_id`) VALUES ('2', '1', '1');

INSERT INTO `role_info` (`id`, `role_name`, `role_desc`, `status`, `is_delete`, `gmt_create`, `gmt_modify`) VALUES ('1', '管理员', '管理员', '0', '0', '2020-05-05 17:58:19', '2020-05-05 17:58:19');

INSERT INTO `user_info` (`id`, `username`, `password`, `status`, `gmt_create`, `gmt_modify`) VALUES ('1', 'kevin', '$2a$10$B0RYiks5phZt8hEqiWRdYe7vDrpQFE1if8NOTqagdRbAFyVKvEPf.', '0', '2020-04-21 23:06:50', '2020-04-22 00:20:58');




/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;