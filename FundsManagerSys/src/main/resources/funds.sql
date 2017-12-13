/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : funds

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-28 15:39:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cost_Inform` float DEFAULT NULL,
  `cost_Meetting` float DEFAULT NULL,
  `cost_Office` float DEFAULT NULL,
  `cost_Other` float DEFAULT NULL,
  `cost_Post` float DEFAULT NULL,
  `cost_SpeMat` float DEFAULT NULL,
  `cost_Travel` float DEFAULT NULL,
  `submit_Time` datetime DEFAULT NULL,
  `total_Expenses` float DEFAULT NULL,
  `submitter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dlri99j2v98u9t5i915cpsva3` (`submitter_id`),
  CONSTRAINT `FK_dlri99j2v98u9t5i915cpsva3` FOREIGN KEY (`submitter_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('1', '0', '1232', '0', '300', '0', '100', '0', '2017-04-28 12:18:25', '1332', '28');
INSERT INTO `bill` VALUES ('2', '0', '0', '0', '0', '0', '800', '0', '2017-04-28 12:24:33', '800', '4');
INSERT INTO `bill` VALUES ('3', '0', '0', '0', '0', '0', '200', '0', '2017-04-28 12:25:56', '200', '26');
INSERT INTO `bill` VALUES ('4', '0', '100', '0', '500', '0', '200', '0', '2017-04-28 12:27:25', '300', '31');
INSERT INTO `bill` VALUES ('5', '0', '100', '0', '0', '0', '100', '0', '2017-04-28 12:59:26', '200', '25');
INSERT INTO `bill` VALUES ('6', '0', '0', '0', '400', '0', '0', '111', '2017-04-11 14:39:23', '111', '8');
INSERT INTO `bill` VALUES ('7', '0', '0', '0', '0', '600', '0', '123', '2017-04-10 14:39:45', '123', '4');
INSERT INTO `bill` VALUES ('25', '0', '100', '0', '0', '100', '100', '100', '2017-04-28 15:24:19', '400', '40');
INSERT INTO `bill` VALUES ('26', '1000', '0', '0', '0', '0', '1000', '1000', '2017-04-28 15:38:02', '3000', '40');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `advance_Amount` float DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `job_Number` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `reimbursed_Expenses` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '7083.67', '3582.33', '19960045', '李焕洲', '96e79218965eb72c92a549dd5a330112', '10666');
INSERT INTO `user` VALUES ('2', '3826.81', '3826.81', '20020053', '唐彰国', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('3', '5734.4', '5734.4', '20010052', '张健', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('4', '1395.8', '1395.8', '20020052', '钟明全', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('5', '44921.4', '39185.4', '20090022', '贾国柱', '96e79218965eb72c92a549dd5a330112', '5736');
INSERT INTO `user` VALUES ('6', '7072.04', '4039.54', '20090073', '刘凤海', '96e79218965eb72c92a549dd5a330112', '3032.5');
INSERT INTO `user` VALUES ('7', '139.58', '139.58', '20040093', '刘莉', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('8', '2907.91', '2907.91', '20130007', '秦爽', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('9', '5210.98', '3758.98', '20000004', '廖磊', '96e79218965eb72c92a549dd5a330112', '1452');
INSERT INTO `user` VALUES ('10', '1721.48', '1721.48', '19980046', '梁文海', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('11', '1407.43', '1407.43', '19980047', '麦文', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('12', '0', '0', '20040094', '毛苏英', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('13', '17610.3', '17610.3', '20090023', '周朝荣', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('14', '2442.64', '837.64', '19990007', '蒋涛', '96e79218965eb72c92a549dd5a330112', '1605');
INSERT INTO `user` VALUES ('15', '5525.03', '5525.03', '20070210', '卫萌菡', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('16', '0', '0', '20090074', '孙三山', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('17', '14132.5', '14132.5', '20130047', '李李', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('18', '3408.07', '3408.07', '20100204', '汪文蝶', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('19', '4896.92', '4896.92', '20130052', '陈冰洁', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('20', '3280.12', '3280.12', '20130048', '徐聪', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('21', '465.27', '465.27', '19950010', '何巍', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('22', '1186.43', '1186.43', '19940042', '赵仕良', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('23', '0', '0', '19930028', '陈万川', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('24', '9514.68', '9514.68', '20130044', '王洪', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('25', '232.63', '232.63', '20050066', '陈敏', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('26', '697.9', '697.9', '20130046', '尚庆红', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('27', '0', '0', '19850047', '罗宇', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('28', '0', '0', '19840038', '金国华', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('29', '18488.5', '18488.5', '20020095', '朱洲森', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('30', '7141.83', '5305.83', '19950060', '熊天信', '96e79218965eb72c92a549dd5a330112', '1836');
INSERT INTO `user` VALUES ('31', '0', '0', '20150027', '丁家琳', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('32', '0', '0', '20150026', '何浩', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('33', '0', '0', '20160003', '李军', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('34', '0', '0', null, '张旋', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('35', '0', '0', '20160016', '贾啸', '96e79218965eb72c92a549dd5a330112', '0');
INSERT INTO `user` VALUES ('40', '10000', '1949', '20140101', 'Tester', '96e79218965eb72c92a549dd5a330112', '8051');
