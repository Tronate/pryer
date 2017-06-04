/*
Navicat MySQL Data Transfer

Source Server         : 210.47.163.67_3306
Source Server Version : 50173
Source Host           : 210.47.163.67:3306
Source Database       : db_ruijie1

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-05-25 12:37:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_allinfotime
-- ----------------------------
DROP TABLE IF EXISTS `tb_allinfotime`;
CREATE TABLE `tb_allinfotime` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `executeTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `executeSumTime` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_mainpage
-- ----------------------------
DROP TABLE IF EXISTS `tb_mainpage`;
CREATE TABLE `tb_mainpage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `accountway` varchar(255) DEFAULT NULL,
  `cycleTime` varchar(255) DEFAULT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `packageflow` varchar(255) DEFAULT NULL,
  `withhold` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=5655 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `messageTime` date DEFAULT NULL,
  `validityTime` date DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `sender` varchar(200) DEFAULT NULL,
  `type1` int(11) DEFAULT NULL,
  `range1` int(11) DEFAULT NULL,
  `account` varchar(200) NOT NULL,
  `flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2275 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_netrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_netrecord`;
CREATE TABLE `tb_netrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `ontime` varchar(255) DEFAULT NULL,
  `offtime` varchar(255) DEFAULT NULL,
  `userIPv4` varchar(255) DEFAULT NULL,
  `service` varchar(255) DEFAULT NULL,
  `offreason` varchar(255) DEFAULT NULL,
  `oncost` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23692 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_time
-- ----------------------------
DROP TABLE IF EXISTS `tb_time`;
CREATE TABLE `tb_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `executeTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `executeSumTime` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7498 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6956 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `zjh` varchar(255) DEFAULT NULL,
  `userIPv4` varchar(255) DEFAULT NULL,
  `connway` varchar(255) DEFAULT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `withholding` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5656 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_zhangwu
-- ----------------------------
DROP TABLE IF EXISTS `tb_zhangwu`;
CREATE TABLE `tb_zhangwu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `billsource` varchar(255) DEFAULT NULL,
  `fee` varchar(255) DEFAULT NULL,
  `nowbalance` varchar(255) DEFAULT NULL,
  `nowwithhold` varchar(255) DEFAULT NULL,
  `generatedtime` varchar(255) DEFAULT NULL,
  `businessvolume` varchar(255) DEFAULT NULL,
  `withholdrole` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123290 DEFAULT CHARSET=utf8;
