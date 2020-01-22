/*
Navicat MySQL Data Transfer

Source Server         : LocalHost
Source Server Version : 50633
Source Host           : localhost:3306
Source Database       : ordersystem

Target Server Type    : MYSQL
Target Server Version : 50633
File Encoding         : 65001

Date: 2019-12-19 11:34:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(50) NOT NULL COMMENT '权限名称',
  `code` varchar(50) NOT NULL COMMENT '权限编码',
  `url` varchar(200) NOT NULL COMMENT 'url',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` int(11) NOT NULL COMMENT '已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('1', '客户订购首页', 'index', '{\"url\":\"/account/findAll\",\"method\":\"GET\"}', '2019-09-30 11:09:02', '2019-12-10 23:17:14', '0');
INSERT INTO `resource` VALUES ('2', '菜单管理首页', 'admin', '{\"url\":\"/menu/redirect/index\",\"method\":\"GET\"}', '2019-09-30 11:09:21', '2019-12-10 17:08:11', '0');
INSERT INTO `resource` VALUES ('3', 'account_index', 'accountIndex', '{\"url\":\"/account/index\",\"method\":\"GET\"}', '2019-12-09 23:26:14', '2019-12-10 23:15:27', '0');
INSERT INTO `resource` VALUES ('4', 'getResourceByUrl', 'getResourceByUrl', '{\"url\":\"/account/getResourceByUrl\",\"method\":\"GET\"}', '2019-12-10 10:48:15', '2019-12-10 23:17:24', '0');
INSERT INTO `resource` VALUES ('5', 'menuFindAll', 'menuFindAll', '{\"url\":\"/menu/findAll\",\"method\":\"GET\"}', '2019-12-10 11:44:05', '2019-12-10 23:15:40', '0');
INSERT INTO `resource` VALUES ('6', 'menuFindById', 'menuFindById', '{\"url\":\"/findById/{id}\",\"method\":\"GET\"}', '2019-12-10 16:46:31', '2019-12-10 23:14:55', '0');
INSERT INTO `resource` VALUES ('7', 'menuUpdate', 'menuUpdate', '{\"url\":\"/menu/update\",\"method\":\"POST\"}', '2019-12-12 09:19:53', '2019-12-12 09:23:15', '0');
INSERT INTO `resource` VALUES ('8', 'menuDeleteById', 'menuDeleteById', '{\"url\":\"/menu/deleteById/{id}\",\"method\":\"GET\"}', '2019-12-12 10:12:58', '2019-12-12 10:12:58', '0');
INSERT INTO `resource` VALUES ('9', 'userManage', 'userManage', '{\"url\":\"/user/user_manage\",\"method\":\"GET\"}', '2019-12-12 14:54:41', '2019-12-17 10:30:39', '0');
INSERT INTO `resource` VALUES ('10', 'userFindAll', 'userFindAll', '{\"url\":\"/user/findAll\",\"method\":\"GET\"}', '2019-12-12 15:25:45', '2019-12-12 15:26:09', '0');
INSERT INTO `resource` VALUES ('11', 'menuManage', 'menuManage', '{\"url\":\"/menu/menu_manage\",\"method\":\"GET\"}', '2019-12-15 23:47:33', '2019-12-15 23:47:53', '0');
INSERT INTO `resource` VALUES ('12', 'userAdd', 'userAdd', '{\"url\":\"/user/user_add\",\"method\":\"GET\"}', '2019-12-17 11:16:09', '2019-12-17 11:17:32', '0');
INSERT INTO `resource` VALUES ('13', 'mange', 'mange', '{\"url\":\"/mange\",\"method\":\"GET\"}', '2019-12-18 22:33:23', '2019-12-18 22:33:34', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `code` varchar(50) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` int(11) NOT NULL COMMENT '已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', 'NORMAL', '2019-09-30 11:09:54', '2019-12-10 17:09:39', '0');
INSERT INTO `role` VALUES ('2', '管理员', 'ADMIN', '2019-09-30 11:10:02', '2019-12-10 17:09:44', '0');

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(32) NOT NULL COMMENT '角色id',
  `resource_id` bigint(32) NOT NULL COMMENT '资源id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` int(11) NOT NULL COMMENT '已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` VALUES ('1', '1', '1', '2019-09-30 11:10:14', '2019-09-30 11:10:14', '0');
INSERT INTO `role_resource` VALUES ('2', '2', '1', '2019-09-30 11:10:21', '2019-09-30 11:10:21', '0');
INSERT INTO `role_resource` VALUES ('3', '2', '2', '2019-09-30 11:10:27', '2019-09-30 11:10:27', '0');
INSERT INTO `role_resource` VALUES ('4', '2', '3', '2019-12-10 10:50:10', '2019-12-10 10:50:10', '0');
INSERT INTO `role_resource` VALUES ('5', '2', '4', '2019-12-10 11:44:28', '2019-12-10 11:44:28', '0');
INSERT INTO `role_resource` VALUES ('6', '2', '5', '2019-12-10 11:44:35', '2019-12-10 11:44:35', '0');
INSERT INTO `role_resource` VALUES ('7', '2', '6', '2019-12-10 16:46:43', '2019-12-10 16:46:43', '0');
INSERT INTO `role_resource` VALUES ('8', '2', '7', '2019-12-12 09:20:08', '2019-12-12 09:20:08', '0');
INSERT INTO `role_resource` VALUES ('9', '1', '2', '2019-12-12 15:07:28', '2019-12-12 15:07:28', '0');
INSERT INTO `role_resource` VALUES ('10', '2', '10', '2019-12-12 17:52:25', '2019-12-12 17:52:25', '0');
INSERT INTO `role_resource` VALUES ('11', '2', '11', '2019-12-15 23:48:07', '2019-12-15 23:48:07', '0');
INSERT INTO `role_resource` VALUES ('12', '2', '9', '2019-12-17 10:35:07', '2019-12-17 10:35:07', '0');
INSERT INTO `role_resource` VALUES ('13', '2', '12', '2019-12-17 11:17:46', '2019-12-17 11:17:46', '0');
INSERT INTO `role_resource` VALUES ('14', '2', '13', '2019-12-18 22:34:00', '2019-12-18 22:34:00', '0');

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor` varchar(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '香酥鸡b', '39', '五香', '1');
INSERT INTO `t_menu` VALUES ('2', '烧椒扣肉', '46', '微辣', '1');
INSERT INTO `t_menu` VALUES ('3', '栗子三杯鸡', '56', '五香', '1');
INSERT INTO `t_menu` VALUES ('4', '毛血旺', '50', '麻辣', '1');
INSERT INTO `t_menu` VALUES ('5', '菠菜拌粉丝', '22', '五香', '2');
INSERT INTO `t_menu` VALUES ('6', '凉拌豆腐皮', '19', '微辣', '2');
INSERT INTO `t_menu` VALUES ('7', '酱牛肉', '36', '麻辣', '2');
INSERT INTO `t_menu` VALUES ('8', '鱼头豆腐汤', '32', '五香', '3');
INSERT INTO `t_menu` VALUES ('9', '瘦肉鸡蛋白菜汤', '30', '五香', '3');
INSERT INTO `t_menu` VALUES ('10', '西葫芦虾仁蒸饺', '26', '五香', '4');
INSERT INTO `t_menu` VALUES ('11', '蛋炒饭', '18', '五香', '4');
INSERT INTO `t_menu` VALUES ('12', '酥粒椰蓉面包', '12', '香甜', '5');
INSERT INTO `t_menu` VALUES ('23', '炒时蔬a', '12', '清淡', '1');
INSERT INTO `t_menu` VALUES ('24', '炒时蔬', '12', '清淡', '1');
INSERT INTO `t_menu` VALUES ('27', '罗非鱼', '100', '清淡', '3');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) NOT NULL,
  `menu_id` bigint(11) NOT NULL,
  `admin_id` bigint(11) DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `state` int(11) DEFAULT '0',
  `is_deleted` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `uid` (`user_id`),
  KEY `mid` (`menu_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1001', '2', '0', '2019-12-18 15:27:20', '2019-12-18 15:27:20', '0', '0');
INSERT INTO `t_order` VALUES ('2', '1001', '10', '0', '2019-12-18 15:27:22', '2019-12-18 15:27:22', '0', '0');
INSERT INTO `t_order` VALUES ('3', '1001', '4', '0', '2019-12-18 17:48:40', '2019-12-18 17:48:40', '0', '0');
INSERT INTO `t_order` VALUES ('4', '1001', '7', '0', '2019-12-18 17:48:42', '2019-12-18 17:48:42', '0', '0');
INSERT INTO `t_order` VALUES ('5', '1001', '9', '0', '2019-12-18 17:48:44', '2019-12-18 17:48:44', '0', '0');
INSERT INTO `t_order` VALUES ('6', '1001', '27', '0', '2019-12-18 17:48:49', '2019-12-18 17:48:49', '0', '0');
INSERT INTO `t_order` VALUES ('7', '1001', '12', '0', '2019-12-18 17:48:52', '2019-12-18 17:48:52', '0', '0');
INSERT INTO `t_order` VALUES ('8', '1001', '23', '0', '2019-12-18 21:21:50', '2019-12-18 21:21:50', '0', '0');
INSERT INTO `t_order` VALUES ('9', '1001', '10', '0', '2019-12-18 21:21:53', '2019-12-18 21:21:53', '0', '0');
INSERT INTO `t_order` VALUES ('10', '1001', '9', '0', '2019-12-18 21:21:55', '2019-12-18 21:21:55', '0', '0');
INSERT INTO `t_order` VALUES ('11', '1001', '3', '0', '2019-12-18 21:21:57', '2019-12-18 21:21:57', '0', '0');
INSERT INTO `t_order` VALUES ('12', '1001', '4', '0', '2019-12-18 21:22:19', '2019-12-18 21:22:19', '0', '0');
INSERT INTO `t_order` VALUES ('13', '1001', '7', '0', '2019-12-18 21:22:22', '2019-12-18 21:22:22', '0', '0');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES ('1', '热菜');
INSERT INTO `t_type` VALUES ('2', '凉菜');
INSERT INTO `t_type` VALUES ('3', '汤羹');
INSERT INTO `t_type` VALUES ('4', '主食');
INSERT INTO `t_type` VALUES ('5', '烘焙');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `nickname` varchar(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `registerdate` date DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zhangsan', '123123', '张三', '男', '13576765678', '2019-02-03', '科技路');
INSERT INTO `t_user` VALUES ('2', 'lisi', '123123', '李四', '女', '18678987676', '2019-02-03', '科技路');
INSERT INTO `t_user` VALUES ('3', 'liuyi', '123456', 'Tonny', '男', '13885110112', '2019-12-09', '南京路100号');
INSERT INTO `t_user` VALUES ('4', 'baby', '123456', '宝宝', '女', '13388123123', '2019-12-09', 'abc');
INSERT INTO `t_user` VALUES ('5', 'latiny', '123456', '静静', '男', '13885109991', '2019-12-09', '上海市徐汇区帝王路100号');
INSERT INTO `t_user` VALUES ('6', 'harry', '123456', '想想', '男', '13885109111', '2019-12-09', '北京路100号');
INSERT INTO `t_user` VALUES ('7', 'wangwu', '123456', '王五', '男', '15188888888', '2019-12-09', '哈哈路');
INSERT INTO `t_user` VALUES ('8', 'nick', '123456', '尼克', '男', '13895123123', '2019-12-09', '123');
INSERT INTO `t_user` VALUES ('9', 'json', '123456', '杰森', '男', '13388123123', '2019-12-09', 'abc');
INSERT INTO `t_user` VALUES ('10', 'hermoine', '123456', '赫敏', '男', '15511123345', '2019-12-09', 'aa');
INSERT INTO `t_user` VALUES ('11', 'roy', '123456', '罗伊', '男', '13388123123', '2019-12-09', 'abc');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `password` varchar(100) NOT NULL COMMENT '密码密文',
  `real_name` varchar(50) NOT NULL COMMENT '真实姓名',
  `phone` bigint(11) NOT NULL COMMENT '手机号',
  `enabled` int(11) NOT NULL COMMENT '是否可用',
  `account_non_expired` int(11) NOT NULL COMMENT '是否过期',
  `account_non_locked` int(11) NOT NULL COMMENT '是否锁定',
  `credentials_non_expired` int(11) NOT NULL COMMENT '证书是否过期',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` int(11) NOT NULL COMMENT '已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1001', 'latiny', '$2a$10$WX3XxL/Cr4yVxdfWObmPG.6MbuInlFkOqyI/ik4TZ7qeIoqfHgLje', 'latiny', '12345678', '1', '1', '1', '1', '2019-09-30 11:11:46', '2019-09-30 15:20:10', '0');
INSERT INTO `users` VALUES ('1002', 'hermione', '$2a$10$WX3XxL/Cr4yVxdfWObmPG.6MbuInlFkOqyI/ik4TZ7qeIoqfHgLje', 'hermione', '12345678', '1', '1', '1', '1', '2019-09-30 11:12:12', '2019-09-30 15:20:10', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(32) NOT NULL COMMENT '用户id',
  `role_id` bigint(32) NOT NULL COMMENT '角色id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` int(11) NOT NULL COMMENT '已删除'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1001', '2', '2019-09-30 11:12:22', '2019-09-30 11:12:22', '0');
INSERT INTO `user_role` VALUES ('1002', '1', '2019-09-30 11:12:27', '2019-09-30 11:12:27', '0');
