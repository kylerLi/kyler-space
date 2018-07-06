/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : jycloud_portal

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2018-07-06 18:18:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` varchar(36) NOT NULL,
  `create_date_time` datetime DEFAULT NULL,
  `status` char(6) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `keywords` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `content` longtext,
  `code` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `summary` longtext,
  `tag_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------

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
INSERT INTO `sequence` VALUES ('SEQ_SYS_M_USER', '34', '1');

-- ----------------------------
-- Table structure for sys_m_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_code`;
CREATE TABLE `sys_m_code` (
  `CODE_SID` bigint(15) NOT NULL COMMENT '微代码SID',
  `CODE_CATEGORY` varchar(64) NOT NULL COMMENT '微代码',
  `CODE_VALUE` varchar(128) NOT NULL COMMENT '微代码值',
  `CODE_DISPLAY` varchar(128) NOT NULL COMMENT '微代码显示值',
  `PARENT_CODE_VALUE` varchar(128) DEFAULT NULL COMMENT '上级微代码值',
  `ENABLED` varchar(1) DEFAULT '1' COMMENT '是否启用(1:启用;0:不启用)',
  `SORT` bigint(9) DEFAULT NULL COMMENT '排序',
  `DESCRIPTION` varchar(1024) DEFAULT NULL COMMENT '描述',
  `ATTRIBUTE_1` varchar(256) DEFAULT NULL COMMENT '属性1',
  `ATTRIBUTE_2` varchar(256) DEFAULT NULL COMMENT '属性',
  `ATTRIBUTE_3` varchar(256) DEFAULT NULL COMMENT '属性3',
  `ATTRIBUTE_4` varchar(256) DEFAULT NULL COMMENT '属性4',
  `ATTRIBUTE_5` varchar(256) DEFAULT NULL COMMENT '属性5',
  `ATTRIBUTE_6` varchar(256) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_DT` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_DT` datetime DEFAULT NULL COMMENT '更新时间',
  `VERSION` bigint(9) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`CODE_SID`),
  KEY `CODE_CATEGORY_IDX` (`CODE_CATEGORY`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统字段设置表';

-- ----------------------------
-- Records of sys_m_code
-- ----------------------------
INSERT INTO `sys_m_code` VALUES ('2278', 'DB_PAGE_SIZE', '8 K', '8 K', '', '1', '1', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2279', 'DB_PAGE_SIZE', '16 K', '16 K', '', '1', '2', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2280', 'DB_PAGE_SIZE', '32 K', '32 K', '', '1', '3', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2281', 'DB_PAGE_SIZE', '64 K', '64 K', '', '1', '4', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2282', 'TABLE_SPACE_TYPE', 'param_tablespace', '参数表空间', '', '1', '1', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2283', 'TABLE_SPACE_TYPE', 'small_tablespace', '小表表空间', '', '1', '2', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2285', 'TABLE_SPACE_TYPE', 'big_tablespace', '大表表空间', null, '1', '3', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2286', 'TABLE_SPACE_TYPE', 'history_tablespace', '历史表表空间', null, '1', '4', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2287', 'PROCESS_TYPE', '25', '项目延期', null, '1', '22', null, null, null, null, null, null, null, 'admin', '2016-09-26 09:42:12', null, '2016-09-26 09:42:12', '1');
INSERT INTO `sys_m_code` VALUES ('2289', 'MGT_OBJ_STATUS', '09', '项目延期审核拒绝', null, '1', '9', null, null, null, null, null, null, null, 'admin', '2016-09-26 09:43:54', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2290', 'TICKET_TYPE', '11', '云主机添加监控失败工单', '', '1', '11', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2291', 'TICKET_TYPE', '12', '云主机创建用户失败工单', '', '1', '12', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');
INSERT INTO `sys_m_code` VALUES ('2292', 'TICKET_TYPE', '13', '云主机创建文件系统失败工单', '', '1', '13', null, null, null, null, null, null, null, 'admin', '2013-10-15 19:28:46', null, null, '1');

-- ----------------------------
-- Table structure for sys_m_code_category
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_code_category`;
CREATE TABLE `sys_m_code_category` (
  `CATEGORY_SID` bigint(15) NOT NULL,
  `CODE_CATEGORY` varchar(32) NOT NULL COMMENT '数据类别',
  `CODE_CATEGORY_NM` varchar(32) NOT NULL COMMENT '数据类别名称',
  `STATE` int(1) DEFAULT '1' COMMENT '数据是否可以编辑（0:不能编辑 1:可编辑）',
  PRIMARY KEY (`CATEGORY_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典分类表';

-- ----------------------------
-- Records of sys_m_code_category
-- ----------------------------
INSERT INTO `sys_m_code_category` VALUES ('1023', 'DB_PAGE_SIZE', 'PageSizw', '1');
INSERT INTO `sys_m_code_category` VALUES ('1024', 'TABLE_SPACE_TYPE', '表空间类型', '1');
INSERT INTO `sys_m_code_category` VALUES ('1025', 'APPLICATION_TYPE', '应用类型', '1');

-- ----------------------------
-- Table structure for sys_m_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_config`;
CREATE TABLE `sys_m_config` (
  `CONFIG_SID` bigint(15) NOT NULL COMMENT '配置SID',
  `CONFIG_TYPE` varchar(64) DEFAULT NULL COMMENT '配置类型',
  `CONFIG_NAME` varchar(128) NOT NULL COMMENT '配置名称',
  `CONFIG_KEY` varchar(64) NOT NULL COMMENT '配置Key',
  `CONFIG_VALUE` varchar(512) NOT NULL COMMENT '配置值',
  `DATA_TYPE` varchar(32) DEFAULT NULL COMMENT '数据类型',
  `DISPLAY_TYPE` varchar(32) DEFAULT NULL COMMENT '显示类型',
  `UNIT` varchar(64) DEFAULT NULL COMMENT '性能单位',
  `VALUE_DOMAIN` varchar(256) DEFAULT NULL COMMENT '取值区域',
  `VALUE_INCREMENT` varchar(256) DEFAULT NULL COMMENT '取值增量',
  `SORT_RANK` int(11) DEFAULT NULL COMMENT '显示顺序',
  `DESCRIPTION` varchar(1024) DEFAULT NULL COMMENT '配置描述',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_DT` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_DT` datetime DEFAULT NULL COMMENT '更新时间',
  `VERSION` bigint(9) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`CONFIG_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统配置表';

-- ----------------------------
-- Records of sys_m_config
-- ----------------------------
INSERT INTO `sys_m_config` VALUES ('1', 'other_config', '系统名称', 'system.name', '广东农信开发测试云', null, null, null, null, null, null, null, 'admin', '2014-01-13 16:11:15', 'admin', '2014-01-13 16:11:15', '1');
INSERT INTO `sys_m_config` VALUES ('2', 'other_config', '公司名称', 'company.name', '广东农信', null, null, null, null, null, null, null, 'admin', '2014-01-13 16:11:15', 'admin', '2014-01-13 16:11:15', '1');
INSERT INTO `sys_m_config` VALUES ('102', 'other_config', '服务限制模式', 'service.limit.mode', 'false', 'boolean', null, null, null, null, null, 'true:是;false:否', 'admin', '2014-01-13 16:11:15', 'admin', '2014-01-15 14:35:27', '1');
INSERT INTO `sys_m_config` VALUES ('103', 'other_config', '默认租户服务限制数量', 'service.limit.tenant.quantity', '2', null, null, null, null, null, null, '\'0\'为无限制', 'admin', '2014-01-13 16:11:15', 'admin', '2014-01-15 14:35:27', '1');
INSERT INTO `sys_m_config` VALUES ('104', 'other_config', '默认用户服务限制数量', 'service.limit.user.quantity', '1', null, null, null, null, null, null, '\'0\'为无限制', 'admin', '2014-01-13 16:11:15', 'admin', '2014-01-15 14:35:27', '1');
INSERT INTO `sys_m_config` VALUES ('106', 'other_config', '是否发送服务通知邮件', 'mail.service.notice.send', 'true', 'boolean', null, null, null, null, '0', 'true:是;false:否', 'admin', '2014-01-13 16:11:15', 'admin3', '2015-06-25 15:03:54', '1');
INSERT INTO `sys_m_config` VALUES ('107', 'other_config', '是否发送帐号激活邮件', 'mail.account.active.send', 'true', 'boolean', null, null, null, null, '0', 'true:是;false:否', 'admin', '2014-01-13 16:11:15', 'admin', '2015-05-07 16:01:35', '1');
INSERT INTO `sys_m_config` VALUES ('108', 'email_config', '发送邮件服务器地址', 'mail.smtp.host', '10.27.128.40', '', null, null, null, null, '0', '', 'admin', '2014-01-13 16:11:15', 'admin', '2015-07-13 13:59:33', '1');
INSERT INTO `sys_m_config` VALUES ('110', 'email_config', '发送邮件账号', 'mail.account', 'klbdc_ypt@klb.com.cn', 'email', null, null, null, null, '2', '', 'admin', '2014-01-13 16:11:15', 'admin', '2015-03-03 15:11:33', '1');
INSERT INTO `sys_m_config` VALUES ('111', 'email_config', '发送邮件用户帐号', 'mail.username', 'klbdc_ypt@klb.com.cn', 'email', null, null, null, null, '3', '', 'admin', '2014-01-13 16:11:15', 'admin', '2015-03-03 15:11:24', '1');
INSERT INTO `sys_m_config` VALUES ('112', 'email_config', '发送邮件用户密码', 'mail.password', 'P@ssw0rd', null, null, null, null, null, '0', '', 'admin', '2014-01-13 16:11:15', 'admin', '2016-08-10 11:06:57', '1');
INSERT INTO `sys_m_config` VALUES ('113', 'email_config', '意见反馈收件人邮箱', 'mail.feedback.address', 'fengyanhonggyq@163.com;lansefengling2014@163.com;caixuekui@yeah.net', 'email', null, null, null, null, '0', '多个邮箱时请用\';\'号隔开', 'admin', '2014-01-13 16:11:15', 'admin', '2015-08-27 15:19:16', '1');
INSERT INTO `sys_m_config` VALUES ('114', 'other_config', '帐号激活地址', 'server.account.active.url', 'http://http://118.192.8.18:8080/pages/register/register-success.jsp', 'url', null, null, null, null, '0', '', 'admin', '2014-01-13 16:11:15', 'admin', '2015-03-26 09:54:04', '1');

-- ----------------------------
-- Table structure for sys_m_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_org`;
CREATE TABLE `sys_m_org` (
  `ORG_SID` bigint(15) NOT NULL,
  `ORG_NAME` varchar(256) NOT NULL,
  `ORG_LEVEL` int(3) NOT NULL,
  `SORT_RANK` bigint(10) DEFAULT NULL,
  `PARENT_ORG_SID` bigint(15) DEFAULT NULL,
  `ORG_DESC` varchar(512) DEFAULT NULL,
  `CREATED_BY` varchar(32) DEFAULT NULL,
  `CREATED_DT` datetime DEFAULT NULL,
  `UPDATED_BY` varchar(32) DEFAULT NULL,
  `UPDATED_DT` datetime DEFAULT NULL,
  `VERSION` bigint(9) DEFAULT NULL,
  PRIMARY KEY (`ORG_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_m_org
-- ----------------------------
INSERT INTO `sys_m_org` VALUES ('1', '广东银信金融服务中心', '1', null, null, '', 'AD', '2016-05-31 16:25:39', 'AD', '2016-05-31 16:25:42', '1');
INSERT INTO `sys_m_org` VALUES ('1030', '信息技术部', '2', '1', '1', '', 'admin', '2016-06-13 14:40:14', 'admin', '2016-06-13 14:40:14', '1');
INSERT INTO `sys_m_org` VALUES ('1031', '软件开发部', '2', '2', '1', '', 'admin', '2016-06-13 14:40:38', 'admin', '2016-06-13 14:40:38', '1');
INSERT INTO `sys_m_org` VALUES ('1032', '运维管理部', '2', '3', '1', '', 'admin', '2016-06-13 14:41:23', 'admin', '2016-06-13 14:41:23', '1');

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
INSERT INTO `sys_m_project` VALUES ('6', null, '项目88', 'project8', '1', '2018-03-15', '2018-03-15', 'ewwe', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_m_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_role`;
CREATE TABLE `sys_m_role` (
  `ROLE_SID` bigint(15) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(128) DEFAULT NULL COMMENT '角色描述',
  `STATUS` varchar(1) NOT NULL DEFAULT '0' COMMENT '角色状态 (1: 锁定; 0: 未锁定)',
  `ROLE_TYPE` varchar(2) DEFAULT NULL COMMENT '角色类型(01:前台角色; 02:后台角色)',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_DT` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_DT` datetime DEFAULT NULL COMMENT '更新时间',
  `DISTRIBUTE` varchar(2) DEFAULT NULL COMMENT '是否能在后台用户管理新增编辑时分配该角色(01:不能被分配; 02:能被分配)',
  `VERSION` bigint(9) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`ROLE_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_m_role
-- ----------------------------
INSERT INTO `sys_m_role` VALUES ('100', '超级管理员', '超级管理员角色', '0', '02', 'admin', '2013-10-09 21:38:50', 'admin', '2015-03-25 14:21:34', '02', '1');
INSERT INTO `sys_m_role` VALUES ('104', '项目成员', '项目成员', '0', '01', 'admin', '2013-10-09 21:38:50', 'admin', '2016-10-17 11:10:24', '02', '1');
INSERT INTO `sys_m_role` VALUES ('200', '部门经理', '部门经理', '0', '02', 'admin', '2016-05-12 15:01:02', 'admin', '2016-05-12 15:01:07', '02', '1');

-- ----------------------------
-- Table structure for sys_m_role_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_role_module`;
CREATE TABLE `sys_m_role_module` (
  `ROLE_SID` bigint(15) NOT NULL COMMENT '角色SID',
  `MODULE_SID` bigint(15) NOT NULL COMMENT '模块SID',
  PRIMARY KEY (`ROLE_SID`,`MODULE_SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色模块表';

-- ----------------------------
-- Records of sys_m_role_module
-- ----------------------------
INSERT INTO `sys_m_role_module` VALUES ('100', '10');
INSERT INTO `sys_m_role_module` VALUES ('100', '11');
INSERT INTO `sys_m_role_module` VALUES ('100', '12');
INSERT INTO `sys_m_role_module` VALUES ('100', '20');
INSERT INTO `sys_m_role_module` VALUES ('100', '21');
INSERT INTO `sys_m_role_module` VALUES ('100', '22');
INSERT INTO `sys_m_role_module` VALUES ('100', '23');
INSERT INTO `sys_m_role_module` VALUES ('100', '30');

-- ----------------------------
-- Table structure for sys_m_sid
-- ----------------------------
DROP TABLE IF EXISTS `sys_m_sid`;
CREATE TABLE `sys_m_sid` (
  `SID` bigint(15) NOT NULL COMMENT '流水号SID',
  `SID_CATEGORY` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '流水号类别代码',
  `SID_CATEGORY_NM` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '流水号类别名称',
  `SID_FREFIX` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '流水号固定值',
  `SID_LENGTH` int(2) DEFAULT NULL COMMENT '流水号长度',
  `IS_DATE` varchar(5) COLLATE utf8_bin DEFAULT NULL COMMENT '是否带有日期(true：带日期 false：不带日期)',
  `DATE_FORMAT` varchar(14) COLLATE utf8_bin DEFAULT NULL COMMENT '日期格式(yyyyMMddhhmmss)',
  `CUR_DATE` varchar(14) COLLATE utf8_bin DEFAULT NULL COMMENT '流水号记录日期',
  `CUR_NO` bigint(9) DEFAULT NULL COMMENT '流水号记录番号',
  `CREATED_BY` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `CREATED_DT` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `UPDATED_DT` datetime DEFAULT NULL COMMENT '更新时间',
  `VERSION` bigint(9) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`SID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='系统流水号管理表';

-- ----------------------------
-- Records of sys_m_sid
-- ----------------------------
INSERT INTO `sys_m_sid` VALUES ('1001', 'ORDER_ID', '订单编号', 'OD', '5', 'true', 'yyyyMMdd', '20161201', '12', null, null, null, null, '1');

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
INSERT INTO `sys_m_user` VALUES ('32', 'lifz', '1234', '123213123', 'lifazhao', '1', 'lifazhao@jieyuechina.com', '15901144845', '1', null, null, null, null, '20', '1', null);
INSERT INTO `sys_m_user` VALUES ('33', 'lifz', '1234', '123213123', 'lifazhao', '1', 'lifazhao@jieyuechina.com', '15901144845', '1', null, null, null, null, '20', '1', null);
INSERT INTO `sys_m_user` VALUES ('34', 'lifz', '1234', '123213123', 'lifazhao', '1', 'lifazhao@jieyuechina.com', '15901144845', '1', null, null, null, null, '20', '1', null);

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
