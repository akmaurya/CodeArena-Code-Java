/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : pe_db

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2016-02-16 15:26:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `firstAddress` varchar(255) NOT NULL,
  `lastAddress` varchar(255) NOT NULL,
  `landmark` varchar(100) DEFAULT NULL,
  `phone` varchar(15) NOT NULL,
  `city` varchar(50) NOT NULL,
  `district` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `pincode` int(20) NOT NULL,
  `users_login_id` varchar(50) NOT NULL,
  `type` int(1) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`type`,`users_login_id`),
  KEY `users_uuid` (`users_login_id`),
  CONSTRAINT `users_address_login_id` FOREIGN KEY (`users_login_id`) REFERENCES `users` (`login_id`),
  CONSTRAINT `address_address_type` FOREIGN KEY (`type`) REFERENCES `address_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `address_type`
-- ----------------------------
DROP TABLE IF EXISTS `address_type`;
CREATE TABLE `address_type` (
  `id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address_type
-- ----------------------------
INSERT INTO `address_type` VALUES ('0', 'Office Address');
INSERT INTO `address_type` VALUES ('1', 'Home Address');

-- ----------------------------
-- Table structure for `employer`
-- ----------------------------
DROP TABLE IF EXISTS `employer`;
CREATE TABLE `employer` (
  `users_login_id` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `companyName` varchar(255) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `isActive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`users_login_id`),
  CONSTRAINT `users_employer_login_id` FOREIGN KEY (`users_login_id`) REFERENCES `users` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employer
-- ----------------------------

-- ----------------------------
-- Table structure for `jobapplied`
-- ----------------------------
DROP TABLE IF EXISTS `jobapplied`;
CREATE TABLE `jobapplied` (
  `comment` varchar(100) DEFAULT NULL,
  `appliedOn` date NOT NULL,
  `users_login_id` varchar(50) NOT NULL,
  `jobPosted_jobId` varchar(32) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`users_login_id`,`jobPosted_jobId`),
  KEY `users_uuid` (`users_login_id`),
  KEY `jobPosted_jobId` (`jobPosted_jobId`),
  CONSTRAINT `jobposted_jobapplied_job_id` FOREIGN KEY (`jobPosted_jobId`) REFERENCES `jobposted` (`jobId`),
  CONSTRAINT `users_jobapplied_login_id` FOREIGN KEY (`users_login_id`) REFERENCES `users` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobapplied
-- ----------------------------

-- ----------------------------
-- Table structure for `jobposted`
-- ----------------------------
DROP TABLE IF EXISTS `jobposted`;
CREATE TABLE `jobposted` (
  `users_login_id` varchar(50) NOT NULL,
  `jobId` varchar(32) NOT NULL,
  `title` varchar(50) NOT NULL,
  `jobprofile` varchar(50) NOT NULL,
  `skills` varchar(255) NOT NULL,
  `location` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `experience` varchar(10) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`users_login_id`,`jobId`),
  KEY `jobId` (`jobId`),
  CONSTRAINT `users_jobposted_login_id` FOREIGN KEY (`users_login_id`) REFERENCES `users` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobposted
-- ----------------------------

-- ----------------------------
-- Table structure for `jobseeker`
-- ----------------------------
DROP TABLE IF EXISTS `jobseeker`;
CREATE TABLE `jobseeker` (
  `users_login_id` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `gender` char(1) NOT NULL DEFAULT 'M',
  `dob` date DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `qualification` varchar(20) DEFAULT NULL,
  `course` varchar(20) DEFAULT NULL,
  `passingYear` int(10) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `experience` varchar(20) DEFAULT NULL,
  `designation` varchar(50) DEFAULT NULL,
  `functionalArea` varchar(150) DEFAULT NULL,
  `companyName` varchar(255) DEFAULT NULL,
  `salary` int(15) DEFAULT NULL,
  `noticePeriod` varchar(10) DEFAULT NULL,
  `preferredLocation` varchar(50) DEFAULT NULL,
  `scalePoint` varchar(255) NOT NULL DEFAULT '1',
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `isActive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`users_login_id`),
  CONSTRAINT `users_job_seekers_login_id` FOREIGN KEY (`users_login_id`) REFERENCES `users` (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jobseeker
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(1) NOT NULL DEFAULT '3',
  `roleName` varchar(20) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'jobseeker', '0');
INSERT INTO `role` VALUES ('2', 'employer', '0');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `login_id` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `role_roleId` int(1) NOT NULL DEFAULT '3',
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`login_id`),
  KEY `users_role_id` (`role_roleId`),
  CONSTRAINT `users_role_id` FOREIGN KEY (`role_roleId`) REFERENCES `role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of users
-- ----------------------------
