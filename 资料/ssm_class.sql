/*
 Navicat Premium Data Transfer

 Source Server         : 虚拟机mysql服务
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 192.168.232.112:3306
 Source Schema         : ssm_class

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 12/12/2021 17:37:40
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
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Item
-- ----------------------------
INSERT INTO `Item` VALUES (1, '面包', 16.0, '投喂自己，饱沃生活', 'sp1.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (2, '冰红茶', 3.5, '康师傅', 'sp2.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (4, '红酒', 116.0, 'nice！', 'sp4.jpg', 1, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (5, '小米', 3699.0, 'nice！', 'phone1.jpg', 2, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (6, '华为', 4799.0, 'nice！', 'phone2.jpg', 2, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');
INSERT INTO `Item` VALUES (9, '鳄鱼牌手提包', 33.0, 'nice！', 'xb1.jpg', 3, '1', '2021-11-01 20:38:18', '1', '2021-11-01 20:38:22');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '商品类别表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of Itemcategory
-- ----------------------------
INSERT INTO `Itemcategory` VALUES (1, '食品', '1', '2021-11-01 20:36:48', '1', '2021-11-01 20:36:52');
INSERT INTO `Itemcategory` VALUES (2, '手机', '1', '2021-11-01 20:36:48', '1', '2021-11-01 20:36:52');
INSERT INTO `Itemcategory` VALUES (3, '箱包', '1', '2021-11-01 20:36:48', '1', '2021-11-01 20:36:52');

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '账户名',
  `money` int(11) NULL DEFAULT NULL COMMENT '账户余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, '张三', 3800);
INSERT INTO `account` VALUES (2, '李四', 6200);
INSERT INTO `account` VALUES (3, '王五', 5000);
INSERT INTO `account` VALUES (4, '范明', 4000);
INSERT INTO `account` VALUES (7, '布凡', 6000);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户编号',
  `username` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '客户名称',
  `jobs` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '职业',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, 'jack', '医生', '13423452351');
INSERT INTO `customer` VALUES (2, 'tom', '建筑师', '15623457531');
INSERT INTO `customer` VALUES (3, 'lili', '会计', '15823512431');
INSERT INTO `customer` VALUES (4, 'admin1', '开发', '15623145631');
INSERT INTO `customer` VALUES (5, 'AQW', '前端', '13425321452');

-- ----------------------------
-- Table structure for m_user
-- ----------------------------
DROP TABLE IF EXISTS `m_user`;
CREATE TABLE `m_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of m_user
-- ----------------------------
INSERT INTO `m_user` VALUES (1, '王五', '2019-08-30', '男', '杭州');
INSERT INTO `m_user` VALUES (2, '张三', '2018-07-10', '男', '北京市');
INSERT INTO `m_user` VALUES (3, '张小明', '2019-08-15', '女', '河南郑州');
INSERT INTO `m_user` VALUES (4, '陈小明', '2019-08-08', '女', '河南郑州');
INSERT INTO `m_user` VALUES (5, '张三丰', '2019-08-15', '男', '长沙');
INSERT INTO `m_user` VALUES (6, '吴小明', '2019-08-08', '女', '河南郑州');
INSERT INTO `m_user` VALUES (7, '王五', '2019-08-14', '女', '武汉');
INSERT INTO `m_user` VALUES (29, '胡同', '2021-11-14', '男', '北京');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `order_id` int(255) NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `product_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, 1, 1);
INSERT INTO `order` VALUES (2, 2, 1);
INSERT INTO `order` VALUES (3, 3, 2);

-- ----------------------------
-- Table structure for t_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单数量',
  `createtime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orders
-- ----------------------------
INSERT INTO `t_orders` VALUES (1, 1, '1', '2021-11-23 12:23:08');
INSERT INTO `t_orders` VALUES (2, 2, '1', '2021-11-22 12:23:51');
INSERT INTO `t_orders` VALUES (3, 3, '1', '2021-11-22 04:24:10');
INSERT INTO `t_orders` VALUES (4, 4, '1', '2021-11-22 04:24:19');

-- ----------------------------
-- Table structure for t_ordersItem
-- ----------------------------
DROP TABLE IF EXISTS `t_ordersItem`;
CREATE TABLE `t_ordersItem`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ordersId` int(4) NOT NULL COMMENT '订单编号',
  `productId` int(4) NOT NULL COMMENT '商品编号',
  `num` int(4) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ordersItem
-- ----------------------------
INSERT INTO `t_ordersItem` VALUES (1, 1, 1, 1);
INSERT INTO `t_ordersItem` VALUES (2, 2, 2, 1);
INSERT INTO `t_ordersItem` VALUES (3, 3, 3, 1);
INSERT INTO `t_ordersItem` VALUES (4, 4, 1, 1);

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product`  (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `price` decimal(9, 2) NOT NULL COMMENT '商品价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES (1, '手机', 4699.00);
INSERT INTO `t_product` VALUES (2, '香水', 345.00);
INSERT INTO `t_product` VALUES (3, '包', 1000.00);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `birthday` date NOT NULL COMMENT '生日',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, '张三丰', '123456', '2021-11-22', '男');
INSERT INTO `t_user` VALUES (2, '张丽', '123456', '2021-11-16', '女');
INSERT INTO `t_user` VALUES (3, '李曼', '123456', '2021-11-16', '女');
INSERT INTO `t_user` VALUES (4, '范明', '123456', '2021-11-02', '男');

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
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zhangsan', '123', '2021-11-23 00:00:00', '男', '1', '1', '2021-11-03 00:00:00', '2021-11-03 00:00:00');
INSERT INTO `user` VALUES (2, '李四', '123456', '2021-11-01 20:34:14', '女', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (3, 'admin', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (4, 'admin1', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (5, 'admin2', '123456', '2021-11-01 20:34:14', '女', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (6, 'admin3', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (7, 'admin4', '123456', '2021-11-01 20:34:14', '男', '1', '1', '2021-11-01 20:34:51', '2021-11-01 20:34:54');
INSERT INTO `user` VALUES (11, 'root', '123', '1999-02-03 00:00:00', '男', '1', '1', '2021-11-03 00:00:00', '2021-11-03 00:00:00');
INSERT INTO `user` VALUES (12, 'lisi', '123456', '1998-12-03 00:00:00', '女', '1', '1', '2021-11-03 00:00:00', '2021-11-03 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
