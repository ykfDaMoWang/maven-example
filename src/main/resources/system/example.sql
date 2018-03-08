/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : example

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-02-28 09:59:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a', '11');
INSERT INTO `user` VALUES ('2', 'b', '12');
INSERT INTO `user` VALUES ('3', 'c', '13');
INSERT INTO `user` VALUES ('4', 'd', '14');
INSERT INTO `user` VALUES ('5', 'ceshi2', '12');
INSERT INTO `user` VALUES ('6', 'ceshi3', '12');
INSERT INTO `user` VALUES ('7', 'ceshi4', '12');
INSERT INTO `user` VALUES ('8', 'ceshi2', '12');
