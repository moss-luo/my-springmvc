/*
SQLyog Job Agent Version 8.32 Copyright(c) Webyog Softworks Pvt. Ltd. All Rights Reserved.


MySQL - 5.5.20 : Database - wissdemo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wissdemo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wissdemo`;

/*Table structure for table `card` */

DROP TABLE IF EXISTS `card`;

CREATE TABLE `card` (
  `id` int(11) DEFAULT NULL,
  `card_num` varchar(255) DEFAULT NULL COMMENT '卡编号',
  `status` int(11) DEFAULT NULL COMMENT '卡状态',
  `valid` tinyint(1) DEFAULT NULL COMMENT '是否合法',
  `type` int(11) DEFAULT NULL COMMENT '门禁卡类型',
  `make_date` varchar(255) DEFAULT NULL COMMENT '卡的创建时间'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `card` */

/*Table structure for table `card_equ` */

DROP TABLE IF EXISTS `card_equ`;

CREATE TABLE `card_equ` (
  `id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  `equ_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `card_equ` */

/*Table structure for table `equipment` */

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment` (
  `id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `error_code` varchar(255) DEFAULT NULL,
  `house_id` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `equipment` */

/*Table structure for table `houses` */

DROP TABLE IF EXISTS `houses`;

CREATE TABLE `houses` (
  `id` int(11) DEFAULT NULL,
  `house_code` varchar(255) DEFAULT NULL COMMENT '房屋编号',
  `address` varchar(10) DEFAULT NULL COMMENT '房屋地址',
  `host_id` int(11) DEFAULT NULL COMMENT '屋主身份证',
  `status` int(11) DEFAULT NULL COMMENT '1为空闲、2为有人',
  `type` tinyint(1) DEFAULT NULL COMMENT '是否为出租屋',
  `customerId` varchar(255) DEFAULT NULL COMMENT '顾客身份证'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `houses` */

/*Table structure for table `p_p` */

DROP TABLE IF EXISTS `p_p`;

CREATE TABLE `p_p` (
  `id` int(11) DEFAULT NULL,
  `m_person_id` int(11) DEFAULT NULL COMMENT '母亲',
  `f_person_id` int(11) DEFAULT NULL COMMENT '父亲',
  `relation` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `p_p` */

/*Table structure for table `persons` */

DROP TABLE IF EXISTS `persons`;

CREATE TABLE `persons` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `hometown` varchar(255) DEFAULT NULL COMMENT '家乡',
  `curr_address` varchar(255) DEFAULT NULL COMMENT '当前居住地',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `card_id` varchar(255) DEFAULT NULL COMMENT '门禁卡id',
  `identity_card_num` varchar(255) DEFAULT NULL COMMENT '身份证',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话号码',
  `guarantee_id` int(11) DEFAULT NULL COMMENT '父母（保证人）id号',
  `is_native` int(11) DEFAULT NULL COMMENT '是否为本地人',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `hourse_id` int(10) DEFAULT NULL COMMENT '房屋Id',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(11) DEFAULT NULL COMMENT '性别'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `persons` */

/*Table structure for table `record_info` */

DROP TABLE IF EXISTS `record_info`;

CREATE TABLE `record_info` (
  `id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL COMMENT '刷卡人',
  `type` int(11) DEFAULT NULL COMMENT '卡的类型',
  `equ_id` int(11) DEFAULT NULL COMMENT '设备id',
  `house_id` int(11) DEFAULT NULL COMMENT '刷卡房屋id',
  `create_time` varchar(255) DEFAULT NULL COMMENT '刷卡时间',
  `card_id` int(11) DEFAULT NULL COMMENT '卡的编号',
  `status` tinyint(1) DEFAULT NULL COMMENT '刷卡是否成功',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `record_info` */

/*Table structure for table `turnover_info` */

DROP TABLE IF EXISTS `turnover_info`;

CREATE TABLE `turnover_info` (
  `id` int(11) DEFAULT NULL,
  `person_id` int(11) DEFAULT NULL,
  `turnover` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  `input_date` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `turnover_info` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
