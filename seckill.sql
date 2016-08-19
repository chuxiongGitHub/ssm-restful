/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : seckill

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-08-19 17:30:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for seckill
-- ----------------------------
DROP TABLE IF EXISTS `seckill`;
CREATE TABLE `seckill` (
  `seckill_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品库存ID',
  `name` varchar(120) NOT NULL COMMENT '商品名称',
  `number` int(11) NOT NULL COMMENT '库存数量',
  `start_time` datetime NOT NULL COMMENT '秒杀开始时间',
  `end_time` datetime NOT NULL COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_ent_time` (`end_time`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1022 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';

-- ----------------------------
-- Records of seckill
-- ----------------------------
INSERT INTO `seckill` VALUES ('1000', '1000元秒杀华为p8', '88', '2016-08-02 00:00:00', '2016-08-08 00:00:00', '2016-08-03 10:22:12');
INSERT INTO `seckill` VALUES ('1001', '100元秒杀红米note2', '99', '2016-08-02 00:00:00', '2016-08-08 00:00:00', '2016-08-03 10:22:12');
INSERT INTO `seckill` VALUES ('1002', '200元秒杀红米3', '10', '2016-08-02 00:00:00', '2016-08-08 00:00:00', '2016-08-03 10:22:12');
INSERT INTO `seckill` VALUES ('1003', '80000元秒杀比亚迪s7', '10', '2016-08-02 00:00:00', '2016-08-08 00:00:00', '2016-08-03 10:22:12');
INSERT INTO `seckill` VALUES ('1004', '比亚迪轿车', '2', '2016-08-04 10:19:38', '2016-08-04 10:19:38', '2016-08-04 10:19:38');
INSERT INTO `seckill` VALUES ('1005', '比亚迪轿车', '2', '2016-08-04 10:20:31', '2016-08-04 10:20:31', '2016-08-04 10:20:31');
INSERT INTO `seckill` VALUES ('1006', '比亚迪轿车', '2', '2016-08-04 15:41:18', '2016-08-04 15:41:18', '2016-08-04 15:41:18');
INSERT INTO `seckill` VALUES ('1007', '比亚迪轿车', '2', '2016-08-04 15:41:50', '2016-08-04 15:41:50', '2016-08-04 15:41:50');
INSERT INTO `seckill` VALUES ('1008', '比亚迪轿车', '2', '2016-08-04 15:50:26', '2016-08-04 15:50:26', '2016-08-04 15:50:26');
INSERT INTO `seckill` VALUES ('1009', '比亚迪轿车', '2', '2016-08-04 15:51:37', '2016-08-04 15:51:37', '2016-08-04 15:51:37');
INSERT INTO `seckill` VALUES ('1010', '比亚迪轿车', '2', '2016-08-04 16:10:57', '2016-08-04 16:10:57', '2016-08-04 16:10:57');
INSERT INTO `seckill` VALUES ('1011', 'dsfsadf', '100', '2016-08-18 00:00:00', '2016-08-25 00:00:00', '2016-08-04 16:22:28');
INSERT INTO `seckill` VALUES ('1012', 'dsfsadf', '100', '2016-08-26 00:00:00', '2016-08-25 00:00:00', '2016-08-04 16:25:43');
INSERT INTO `seckill` VALUES ('1013', 'dsfsadf', '100', '2016-08-18 16:27:34', '2016-08-24 16:27:37', '2016-08-04 16:27:45');
INSERT INTO `seckill` VALUES ('1014', 'dsfsadf', '100', '2016-08-19 16:35:20', '2016-08-31 16:35:23', '2016-08-04 16:35:27');
INSERT INTO `seckill` VALUES ('1015', 'dsfsadf', '100', '2016-08-17 16:39:17', '2016-08-31 16:39:19', '2016-08-04 16:39:22');
INSERT INTO `seckill` VALUES ('1016', 'dsfsadf', '100', '2016-08-18 16:40:13', '2016-08-27 16:40:16', '2016-08-04 16:40:19');
INSERT INTO `seckill` VALUES ('1017', 'dsfsadf', '100', '2016-08-19 16:46:57', '2016-08-31 16:47:00', '2016-08-04 16:47:03');
INSERT INTO `seckill` VALUES ('1018', '是大家发牢骚的附件', '499', '2016-08-04 09:53:57', '2016-08-25 09:53:59', '2016-08-05 09:54:03');
INSERT INTO `seckill` VALUES ('1019', '马上就中秋了', '100', '2016-08-12 10:01:40', '2016-08-25 10:01:43', '2016-08-08 10:01:45');
INSERT INTO `seckill` VALUES ('1020', '马上就中秋了', '100', '2016-08-19 10:03:04', '2016-08-17 10:03:07', '2016-08-08 10:03:10');
INSERT INTO `seckill` VALUES ('1021', '多舒服撒旦分', '555', '2016-08-11 10:59:50', '2016-08-26 10:59:53', '2016-08-08 10:59:55');

-- ----------------------------
-- Table structure for success_killed
-- ----------------------------
DROP TABLE IF EXISTS `success_killed`;
CREATE TABLE `success_killed` (
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品的ID',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号码',
  `status` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态表示：-1：无效，0：成功，1：已付款',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`,`user_phone`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- ----------------------------
-- Records of success_killed
-- ----------------------------
INSERT INTO `success_killed` VALUES ('1000', '13698740791', '-1', '2016-08-04 15:15:12');
INSERT INTO `success_killed` VALUES ('1001', '13698740791', '-1', '2016-08-04 15:16:03');
INSERT INTO `success_killed` VALUES ('1018', '13698740791', '-1', '2016-08-08 09:41:13');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `age` int(11) NOT NULL COMMENT '年龄',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`user_id`),
  KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'sdfsdf', 'sdfasdf', '2', '2016-08-08 14:49:11');
INSERT INTO `user` VALUES ('10', 'rainbow', '123', '5', '2016-08-15 14:40:18');
