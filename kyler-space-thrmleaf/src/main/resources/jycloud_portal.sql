/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : jycloud_portal

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-03-09 13:36:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sequence
-- ----------------------------
DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `name` varchar(50) NOT NULL,
  `current_value` bigint(20) unsigned NOT NULL DEFAULT '0',
  `increment` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence
-- ----------------------------
INSERT INTO `sequence` VALUES ('SEQ_SYS_M_PROJECT', '9', '1');
INSERT INTO `sequence` VALUES ('SEQ_SYS_M_USER', '31', '1');

-- ----------------------------
-- Table structure for sys_m_project
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_project`;
CREATE TABLE `sys_m_project` (
  `PROJECT_SID` bigint(15) NOT NULL,
  `ORG_SID` bigint(15) DEFAULT NULL,
  `PROJECT_NAME` varchar(128) NOT NULL,
  `PROJECT_ENAME` varchar(256) DEFAULT NULL,
  `STATUS` varchar(2) DEFAULT NULL,
  `PROJECT_START_TIME` date DEFAULT NULL,
  `PROJECT_END_TIME` date DEFAULT NULL,
  `PROJECT_DESC` text,
  `PROJECR_FILES` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_DT` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_DT` datetime DEFAULT NULL,
  `VERSION` bigint(9) DEFAULT NULL,
  PRIMARY KEY (`PROJECT_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_m_project
-- ----------------------------
INSERT INTO `sys_m_project` VALUES ('3', null, '项目3', 'project3', '1', '2018-03-09', '2018-03-10', 'sdsdsdddd', null, null, null, null, null, null);
INSERT INTO `sys_m_project` VALUES ('6', null, '项目8', 'project8', '1', '2018-03-15', '2018-03-15', 'ewwe', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_m_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_user`;
CREATE TABLE `sys_m_user` (
  `USER_SID` bigint(20) NOT NULL,
  `ACCOUNT` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PASSWORD64` varchar(255) DEFAULT NULL,
  `REAL_NAME` varchar(255) DEFAULT NULL,
  `SEX` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `MOBILE` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `CREATED_DT` datetime DEFAULT NULL,
  `UPDATED_DT` datetime DEFAULT NULL,
  `VERSION` varchar(255) DEFAULT NULL,
  `ORG_SID` bigint(20) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL,
  `UPDATED_BY` varchar(0) DEFAULT NULL,
  PRIMARY KEY (`USER_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_m_user
-- ----------------------------
INSERT INTO `sys_m_user` VALUES ('3', 'lifz', '111111111', null, '李法钊', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('20', 'jieyue-4', '111111111', null, 'jieyueU4', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('22', 'jycloud5', '111111111', null, 'jycloud5', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('23', 'jieyue-4', '111111111', null, 'jieyueU4', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('24', 'jycloud5', '111111111', null, 'jycloud5', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('25', 'jieyue-4', '111111111', null, 'jieyueU4', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('26', 'jycloud5', '111111111', null, 'jycloud5', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('27', 'jieyue-4', '111111111', null, 'jieyueU4', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('28', 'jycloud5', '111111111', null, 'jycloud5', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('29', 'jieyue-4', '111111111', null, 'jieyueU4', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('30', 'jycloud5', '111111111', null, 'jycloud5', '1', 'lifazhao@sina.cn', '15901144845', null, null, null, null, null, null, null, null);
INSERT INTO `sys_m_user` VALUES ('31', 'jyp1', '111111111', null, '贾永鹏', '0', 'jiayongpeng', '15901144845', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Function structure for currval
-- ----------------------------
DROP FUNCTION IF EXISTS `currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `currval`(seq_name VARCHAR(50)) RETURNS bigint(20)
BEGIN
         DECLARE value BIGINT;
         SELECT current_value INTO value
         FROM sequence
         WHERE upper(name) = upper(seq_name); 
         RETURN value;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `nextval`(seq_name VARCHAR(50)) RETURNS bigint(20)
BEGIN  
         DECLARE value BIGINT;
         UPDATE sequence  
         SET current_value = current_value + increment  
         WHERE upper(name) = upper(seq_name);
         RETURN currval(seq_name);  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for setval
-- ----------------------------
DROP FUNCTION IF EXISTS `setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `setval`(seq_name VARCHAR(50), value BIGINT) RETURNS bigint(20)
BEGIN 
         UPDATE sequence  
         SET current_value = value  
         WHERE upper(name) = upper(seq_name);  
         RETURN currval(seq_name);  
END
;;
DELIMITER ;
