/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 101.34.235.93:3306
 Source Schema         : ssm_class

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 01/11/2021 21:30:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Item
-- ----------------------------
DROP TABLE IF EXISTS `Item`;
CREATE TABLE `Item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10, 1) NULL DEFAULT NULL COMMENT '商品价格',
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品描述',
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品图片',
  `cid` int(11) NULL DEFAULT NULL COMMENT '商品类别',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Item
-- ----------------------------
INSERT INTO `Item` VALUES (1, '面包', 15.0, '投喂自己，饱沃生活', 'sp1.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (2, '冰红茶', 4.0, '品味', 'sp2.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (3, '饼干', 9.0, 'nice！', 'sp3.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (4, '红酒', 116.0, 'nice！', 'sp4.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (5, '小米', 3699.0, 'nice！', 'phone1.jpg', 2, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (6, '华为', 4799.0, 'nice！', 'phone2.jpg', 2, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (7, 'open', 3429.0, 'nice！', 'phone3.jpg', 2, '1', '2021-11-01 20:56:19', '1', NULL);
INSERT INTO `Item` VALUES (8, 'iphone13', 6799.0, 'nice！', 'phone4.jpg', 2, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (9, '鳄鱼牌手提包', 33.0, 'nice！', 'xb1.jpg', 3, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (10, '挎包', 56.0, 'nice！', 'xb2.jpg', 3, '1', '2021-11-01 20:56:16', '1', NULL);
INSERT INTO `Item` VALUES (11, '手挎包', 188.0, 'nice！', 'xb3.jpg', 3, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (12, '行李箱', 222.0, 'nice！', 'xb4.jpg', 3, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');

-- ----------------------------
-- Table structure for Itemcategory
-- ----------------------------
DROP TABLE IF EXISTS `Itemcategory`;
CREATE TABLE `Itemcategory`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类别id',
  `cateName` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类别名称',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of Itemcategory
-- ----------------------------
INSERT INTO `Itemcategory` VALUES (1, '食品', '1', '2021-11-01 20:36:48', '1', '2021-11-01 20:36:52');
INSERT INTO `Itemcategory` VALUES (2, '手机', '1', '2021-11-01 20:36:48', '1', '2021-11-01 20:36:52');
INSERT INTO `Itemcategory` VALUES (3, '箱包', '1', '2021-11-01 20:36:48', '1', '2021-11-01 20:36:52');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  `birthday` datetime NOT NULL COMMENT '出生日期',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '性别',
  `CREATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '创建人',
  `UPDATED_BY` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '更新人',
  `CREATED_TIME` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATED_TIME` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (2, '李四', '123456', '2021-11-01 20:34:14', '女', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (3, 'admin', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (4, 'admin1', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (5, 'admin2', '123456', '2021-11-01 20:34:14', '女', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (6, 'admin3', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (7, 'admin4', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');

SET FOREIGN_KEY_CHECKS = 1;
