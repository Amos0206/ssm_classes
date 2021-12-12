/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : class_demo

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 12/12/2021 17:35:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for movie_type
-- ----------------------------
DROP TABLE IF EXISTS `movie_type`;
CREATE TABLE `movie_type`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of movie_type
-- ----------------------------
INSERT INTO `movie_type` VALUES (1, '剧情');
INSERT INTO `movie_type` VALUES (2, '喜剧');
INSERT INTO `movie_type` VALUES (3, '动作');
INSERT INTO `movie_type` VALUES (4, '爱情');
INSERT INTO `movie_type` VALUES (5, '惊悚');
INSERT INTO `movie_type` VALUES (6, '犯罪');
INSERT INTO `movie_type` VALUES (7, '悬疑');
INSERT INTO `movie_type` VALUES (8, '战争');
INSERT INTO `movie_type` VALUES (10, '科幻');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账号',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for t_movie
-- ----------------------------
DROP TABLE IF EXISTS `t_movie`;
CREATE TABLE `t_movie`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '电影名',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '封面',
  `director` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '导演',
  `actor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '演员',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '类型',
  `m_desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `v_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_movie
-- ----------------------------
INSERT INTO `t_movie` VALUES (6, '夏洛特烦恼', 'group1/M00/00/00/rBEQCmG1sCyAOyBgAARxeVeiH3A064.png', '闫非、彭大魔', '沈腾、马丽、王宁  、艾伦、王智、宋阳..等', '喜剧', '夏洛前去参加自己曾经暗恋的校花秋雅在豪华酒店隆重举行的婚礼，为她祝酒时夏洛面对周围事业成功的老同学，发现只有自己一事无成，心中泛酸，借着几分酒意大闹婚礼现场，甚至惊动了110。而他发泄过后却在马桶上睡着了，梦里重回高中，报复了羞辱过他的老师、追求到心爱的女孩、让失望的母亲重展笑颜，甚至成为知名作家、音乐人、网络红人，一连串事件在不可思议中火速发生。', 'https://www.pianku.li/py/lNGOiljNykmZ_1.html?163152');
INSERT INTO `t_movie` VALUES (7, '疯狂的麦克斯4', 'group1/M00/00/00/rBEQCmG1sjaAcCmyAABnsnWmnzc560.png', '米勒', ' 汤姆·哈迪 / 查理兹·塞隆 / 尼古拉斯·霍尔特..等', '动作', '未来世界，水资源短缺引发了连绵的战争。人们相互厮杀，争夺有限的资源，地球变成了血腥十足的杀戮死战场。面容恐怖的不死乔在戈壁山谷建立了难以撼动的强大武装王国，他手下的战郎驾驶装备尖端武器的战车四下抢掠，杀伐无度，甚至将自己的孩子打造成战争机器。', 'https://www.pianku.li/py/lNGO2c2Y3MDb_1.html?163149');
INSERT INTO `t_movie` VALUES (8, '三傻大闹宝莱坞', 'group1/M00/00/00/rBEQCmG1tH6AWFNWAARXKoLYiQM182.png', '拉库马·希拉尼', '阿米尔·汗、马德哈万、沙尔曼·乔什、卡琳娜·卡普', '剧情', '法罕、拉加和兰彻是同寝的大学同学，他们都在印度的著名学府帝国工业大学就读。法罕其实并不想学工业设计，他想成为一名野外摄影师；拉加的家庭十分贫困，他的家人希望莱吉毕业后能找个好工作以改善家庭的经济状况；而兰彻的身世一直是一个谜。这个谜要到他们毕业十年之后才能揭晓。....', 'https://www.pianku.li/py/lRWZ2cDbrdWY_1.html?163088');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '标题',
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '作者',
  `create_date` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '描述',
  `new_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES (1, 'test', 'a', '2021-12-07 13:26:37', 'afatest', 'htp:afa.com');
INSERT INTO `t_news` VALUES (2, 'test', 'a', '2021-12-07 13:26:37', 'afatest', 'htp:afa.com');

SET FOREIGN_KEY_CHECKS = 1;
