/*
 Navicat Premium Data Transfer

 Source Server         : local host
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : 10.123.199.197:3306
 Source Schema         : shiro

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 08/03/2018 13:34:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_resources`;
CREATE TABLE `sys_resources`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `resUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源url',
  `type` int(11) NULL DEFAULT NULL COMMENT '资源类型   1:菜单    2：按钮',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '父资源',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resources
-- ----------------------------
INSERT INTO `sys_resources` VALUES (1, '系统设置', '/system', 0, 0, 1);
INSERT INTO `sys_resources` VALUES (2, '用户管理', '/api/get/system/user/topage', 1, 1, 2);
INSERT INTO `sys_resources` VALUES (3, '角色管理', '/rolesPage', 1, 1, 3);
INSERT INTO `sys_resources` VALUES (4, '资源管理', '/resourcesPage', 1, 1, 4);
INSERT INTO `sys_resources` VALUES (5, '添加用户', '/users/add', 2, 2, 5);
INSERT INTO `sys_resources` VALUES (6, '删除用户', '/users/delete', 2, 2, 6);
INSERT INTO `sys_resources` VALUES (7, '添加角色', '/roles/add', 2, 3, 7);
INSERT INTO `sys_resources` VALUES (8, '删除角色', '/roles/delete', 2, 3, 8);
INSERT INTO `sys_resources` VALUES (9, '添加资源', '/resources/add', 2, 4, 9);
INSERT INTO `sys_resources` VALUES (10, '删除资源', '/resources/delete', 2, 4, 10);
INSERT INTO `sys_resources` VALUES (11, '分配角色', '/users/saveUserRoles', 2, 2, 11);
INSERT INTO `sys_resources` VALUES (13, '分配权限', '/roles/saveRoleResources', 2, 3, 12);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员');
INSERT INTO `sys_role` VALUES (2, '普通用户');
INSERT INTO `sys_role` VALUES (3, '超级管理员');

-- ----------------------------
-- Table structure for sys_role_resources
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_resources`;
CREATE TABLE `sys_role_resources`  (
  `roleId` int(11) NOT NULL,
  `resourcesId` int(11) NOT NULL,
  PRIMARY KEY (`roleId`, `resourcesId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_resources
-- ----------------------------
INSERT INTO `sys_role_resources` VALUES (1, 2);
INSERT INTO `sys_role_resources` VALUES (1, 3);
INSERT INTO `sys_role_resources` VALUES (1, 4);
INSERT INTO `sys_role_resources` VALUES (1, 5);
INSERT INTO `sys_role_resources` VALUES (1, 6);
INSERT INTO `sys_role_resources` VALUES (1, 7);
INSERT INTO `sys_role_resources` VALUES (1, 8);
INSERT INTO `sys_role_resources` VALUES (1, 9);
INSERT INTO `sys_role_resources` VALUES (1, 10);
INSERT INTO `sys_role_resources` VALUES (1, 11);
INSERT INTO `sys_role_resources` VALUES (1, 13);
INSERT INTO `sys_role_resources` VALUES (2, 2);
INSERT INTO `sys_role_resources` VALUES (2, 3);
INSERT INTO `sys_role_resources` VALUES (2, 5);
INSERT INTO `sys_role_resources` VALUES (2, 6);
INSERT INTO `sys_role_resources` VALUES (2, 7);
INSERT INTO `sys_role_resources` VALUES (2, 8);
INSERT INTO `sys_role_resources` VALUES (2, 11);
INSERT INTO `sys_role_resources` VALUES (2, 13);
INSERT INTO `sys_role_resources` VALUES (3, 2);
INSERT INTO `sys_role_resources` VALUES (3, 3);
INSERT INTO `sys_role_resources` VALUES (3, 4);
INSERT INTO `sys_role_resources` VALUES (3, 5);
INSERT INTO `sys_role_resources` VALUES (3, 7);
INSERT INTO `sys_role_resources` VALUES (3, 8);
INSERT INTO `sys_role_resources` VALUES (3, 9);
INSERT INTO `sys_role_resources` VALUES (3, 10);
INSERT INTO `sys_role_resources` VALUES (9, 9);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(33) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `enable` int(10) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', 1);
INSERT INTO `sys_user` VALUES (2, 'user1', '90e66e36e3135a91d298177d4389851e', 1);
INSERT INTO `sys_user` VALUES (3, 'user2', '121', 0);
INSERT INTO `sys_user` VALUES (4, 'user3', 'user3', 1);
INSERT INTO `sys_user` VALUES (5, 'user4', 'user4', 1);
INSERT INTO `sys_user` VALUES (6, 'user5', 'user5', 1);
INSERT INTO `sys_user` VALUES (7, 'user6', 'user6', 1);
INSERT INTO `sys_user` VALUES (8, 'user7', 'user7', 1);
INSERT INTO `sys_user` VALUES (9, 'user8', 'user8', 1);
INSERT INTO `sys_user` VALUES (10, 'user9', 'user9', 1);
INSERT INTO `sys_user` VALUES (11, 'user10', 'user10', 1);
INSERT INTO `sys_user` VALUES (12, 'user11', 'user11', 1);
INSERT INTO `sys_user` VALUES (13, 'user12', 'user12', 1);
INSERT INTO `sys_user` VALUES (14, 'user13', 'user13', 1);
INSERT INTO `sys_user` VALUES (15, 'user14', 'user14', 1);
INSERT INTO `sys_user` VALUES (16, 'user15', 'user15', 1);
INSERT INTO `sys_user` VALUES (17, 'user16', 'user16', 1);
INSERT INTO `sys_user` VALUES (18, 'user17', 'user17', 1);
INSERT INTO `sys_user` VALUES (19, 'user18', 'user18', 1);
INSERT INTO `sys_user` VALUES (21, 'user20', 'user20', 1);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `userId` int(11) NULL DEFAULT NULL,
  `roleId` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (23, 2);
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (3, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

-- ----------------------------
-- Procedure structure for init_shiro_demo
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_shiro_demo`;
delimiter ;;
CREATE DEFINER=`root`@`%` PROCEDURE `init_shiro_demo`()
BEGIN	
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - 
*********************************************************************
*/
/*表结构插入*/
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role` */
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role_permission` */
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*Table structure for table `u_user` */
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*Table structure for table `u_user_role` */
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - i_wenyiba_com
*********************************************************************
*/
/*所有的表数据插入*/
/*Data for the table `u_permission` */
insert  into `u_permission`(`id`,`url`,`name`) values (4,'/permission/index.shtml','权限列表'),(6,'/permission/addPermission.shtml','权限添加'),(7,'/permission/deletePermissionById.shtml','权限删除'),(8,'/member/list.shtml','用户列表'),(9,'/member/online.shtml','在线用户'),(10,'/member/changeSessionStatus.shtml','用户Session踢出'),(11,'/member/forbidUserById.shtml','用户激活&禁止'),(12,'/member/deleteUserById.shtml','用户删除'),(13,'/permission/addPermission2Role.shtml','权限分配'),(14,'/role/clearRoleByUserIds.shtml','用户角色分配清空'),(15,'/role/addRole2User.shtml','角色分配保存'),(16,'/role/deleteRoleById.shtml','角色列表删除'),(17,'/role/addRole.shtml','角色列表添加'),(18,'/role/index.shtml','角色列表'),(19,'/permission/allocation.shtml','权限分配'),(20,'/role/allocation.shtml','角色分配');
/*Data for the table `u_role` */
insert  into `u_role`(`id`,`name`,`type`) values (1,'系统管理员','888888'),(3,'权限角色','100003'),(4,'用户中心','100002');
/*Data for the table `u_role_permission` */
insert  into `u_role_permission`(`rid`,`pid`) values (4,8),(4,9),(4,10),(4,11),(4,12),(3,4),(3,6),(3,7),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20);
/*Data for the table `u_user` */
insert  into `u_user`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values (1,'管理员','admin','9c3250081c7b1f5c6cbb8096e3e1cd04','2016-06-16 11:15:33','2016-06-16 11:24:10',1),(11,'soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),(12,'8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);
/*Data for the table `u_user_role` */
insert  into `u_user_role`(`uid`,`rid`) values (12,4),(11,3),(11,4),(1,1);
   
    END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
