/*
Navicat MySQL Data Transfer

Source Server         : IndustrialProject
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : items

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-10-31 00:52:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `client`
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `clientEmail` char(40) NOT NULL,
  `clientPassword` char(40) NOT NULL,
  `clientName` char(40) NOT NULL,
  `clientContact` char(10) DEFAULT NULL,
  PRIMARY KEY (`clientEmail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('a', 'a', 'a', '6');
INSERT INTO `client` VALUES ('akash.verma@gmail.com', 'akash@1234', 'Akash Verma', '9455355342');
INSERT INTO `client` VALUES ('akash111@gmail.com', '34567', 'Arvind', '9918508601');
INSERT INTO `client` VALUES ('arvindbhumca@gmail.com', '34567', 'Arvind', '9918508601');
INSERT INTO `client` VALUES ('rajatkumarmaury', '22398', 'Rajatwa', '9918508601');
INSERT INTO `client` VALUES ('rajatkumarmaury@gmail.com', '8565005534', 'Rajat kumar Maurya', '8565005534');
INSERT INTO `client` VALUES ('rani@gmail.com', '34567', 'Rani', '89789798');
INSERT INTO `client` VALUES ('sanjaysanjay500@gmail.com', 'sanjay8181867112', 'Sanjay Kumar Bind', '8601868685');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemId` char(10) NOT NULL,
  `itemName` char(30) NOT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('Copy', 'Copy');
INSERT INTO `item` VALUES ('keyboard', 'keyboard');
INSERT INTO `item` VALUES ('lapy', 'lapy');
INSERT INTO `item` VALUES ('mobile', 'mobile');
INSERT INTO `item` VALUES ('Paste', 'Paste');

-- ----------------------------
-- Table structure for `place`
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place` (
  `placeId` char(10) NOT NULL,
  `placeName` char(30) NOT NULL,
  PRIMARY KEY (`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of place
-- ----------------------------
INSERT INTO `place` VALUES ('Bag', 'Bag');
INSERT INTO `place` VALUES ('desk', 'desk');
INSERT INTO `place` VALUES ('hand', 'hand');

-- ----------------------------
-- Table structure for `placeditem`
-- ----------------------------
DROP TABLE IF EXISTS `placeditem`;
CREATE TABLE `placeditem` (
  `clientId` char(40) NOT NULL,
  `itemId` char(10) NOT NULL,
  `placeId` char(10) NOT NULL,
  PRIMARY KEY (`clientId`,`itemId`,`placeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of placeditem
-- ----------------------------
INSERT INTO `placeditem` VALUES ('a', 'mobile', 'hand');
INSERT INTO `placeditem` VALUES ('rajatkumarmaury@gmail.com', 'Copy', 'desk');
INSERT INTO `placeditem` VALUES ('rajatkumarmaury@gmail.com', 'keyboard', 'desk');
INSERT INTO `placeditem` VALUES ('rajatkumarmaury@gmail.com', 'lapy', 'desk');
INSERT INTO `placeditem` VALUES ('rajatkumarmaury@gmail.com', 'mobile', 'Bag');
INSERT INTO `placeditem` VALUES ('rajatkumarmaury@gmail.com', 'mobile', 'desk');
INSERT INTO `placeditem` VALUES ('sanjaysanjay500@gmail.com', 'Paste', 'Bag');
