/*
Navicat MySQL Data Transfer

Source Server         : vince
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : growthbar

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-09-16 16:05:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(1) NOT NULL AUTO_INCREMENT COMMENT '活动编号',
  `activity_content` varchar(20) NOT NULL COMMENT '活动内容',
  `activity_place` varchar(255) DEFAULT NULL COMMENT '活动地点',
  `activity_time` varchar(255) NOT NULL COMMENT '活动时间',
  `status` int(2) NOT NULL COMMENT '活动状态',
  `activity_compere` varchar(255) DEFAULT NULL COMMENT '活动主讲人、主持人',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '宣讲会', '二教', '2017-03-14 14:12:23', '0', '张世俊');

-- ----------------------------
-- Table structure for `appointment`
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约编号',
  `activity_id` int(1) NOT NULL COMMENT '活动编号',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '用户账号',
  `description` text NOT NULL COMMENT '备注',
  `user_tel` char(11) NOT NULL COMMENT '联系方式',
  `status` int(2) NOT NULL COMMENT '预约状态',
  `time` varchar(255) NOT NULL COMMENT '预约时间',
  PRIMARY KEY (`appointment_id`),
  KEY `user_appointment_tel` (`user_tel`),
  KEY `user_activity_id` (`activity_id`),
  CONSTRAINT `activity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_appointment_tel` FOREIGN KEY (`user_tel`) REFERENCES `user_information` (`user_phone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('1', '1', 'zhangjianshun', '我想加入', '15208316895', '-1', '2017-09-15 17:03:30');
INSERT INTO `appointment` VALUES ('2', '1', 'zhangjianshun', '我想加入', '15208316895', '1', '2017-09-15 17:24:27');

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章编号',
  `article_title` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '文章标题',
  `user_account` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '发布者编号',
  `article_content` text CHARACTER SET utf8 NOT NULL COMMENT '文章内容',
  `post_time` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '发布时间',
  `status` int(2) NOT NULL COMMENT '文章状态',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'title', 'asd', 'content', '1501212650', '1');
INSERT INTO `article` VALUES ('2', 'title', 'aaa', '123', '2017-08-29 15:44:30.746', '-1');
INSERT INTO `article` VALUES ('3', 'title-修改测试', 'test-user', '123', '2017-08-29 17:03:53.223', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `post_id` int(11) NOT NULL COMMENT '帖子编号',
  `user_account` varchar(20) NOT NULL COMMENT '用户编号',
  `comment_content` varchar(50) NOT NULL COMMENT '评论内容',
  `comment_time` varchar(255) NOT NULL COMMENT '评论时间',
  `status` int(2) NOT NULL COMMENT '评论状态',
  `parent_id` int(11) NOT NULL COMMENT '父评论编号',
  PRIMARY KEY (`comment_id`),
  KEY `user_postbar_id` (`user_account`),
  CONSTRAINT `user_postbar_id` FOREIGN KEY (`user_account`) REFERENCES `user_information` (`user_account`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `exam_result`
-- ----------------------------
DROP TABLE IF EXISTS `exam_result`;
CREATE TABLE `exam_result` (
  `user_account` varchar(255) NOT NULL,
  `qutihua` varchar(255) NOT NULL,
  `qiangpo` varchar(255) NOT NULL,
  `jiaolv` varchar(255) NOT NULL,
  `didui` varchar(255) NOT NULL,
  `kongbu` varchar(255) NOT NULL,
  `pianzhi` varchar(255) NOT NULL,
  `jingshenbing` varchar(255) NOT NULL,
  `shuimian` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `exam_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam_result
-- ----------------------------
INSERT INTO `exam_result` VALUES ('zhangguangyu', '0.9166666666666666', '1', '1', '1', '1', '1', '1', '1', '2017-09-16 14:38:20.718', '1');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '2.25', '2.5', '1.8', '1.3333333333333333', '1.8571428571428572', 'NaN', '3.1', '2', '2017-09-16 14:43:30.809', '2');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '2.25', '2.5', '1.8', '1.3333333333333333', '1.8571428571428572', '1.5', '3.1', '2', '2017-09-16 14:43:30.809', '3');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '1.5', '1.2', '1.8', '1', '1', '1.5', '1.5', '1.1428571428571428', '2017-09-16 14:52:06.234', '4');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '2.0833333333333335', '2', '2', '2.5', '2.4285714285714284', '1.6666666666666667', '3.3', '1.5714285714285714', '2017-09-16 15:02:30.451', '5');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '2.1666666666666665', '2', '1.6', '1.5', '2.4285714285714284', '3.5', '2.5', 'NaN', '2017-09-16 15:06:00.164', '6');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '3', '2.5', '2.2', '2.5', '2.142857142857143', '2.5', 'NaN', '2.2857142857142856', '2017-09-16 15:06:00.164', '7');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '2.9166666666666665', '2.8', '2.6', '3.3333333333333335', '3.142857142857143', '3.1666666666666665', '2.8', '3.5714285714285716', '2017-09-16 15:16:56.712', '8');
INSERT INTO `exam_result` VALUES ('zhangguangyu', '2.9166666666666665', '2.8', '2.6', '3.3333333333333335', '3.142857142857143', '3.1666666666666665', '2.8', '3.5714285714285716', '2017-09-16 15:16:56.712', '9');

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子编号',
  `post_title` varchar(255) NOT NULL COMMENT '帖子标题',
  `post_content` varchar(255) NOT NULL COMMENT '帖子内容',
  `post_time` varchar(255) NOT NULL COMMENT '发帖时间',
  `user_account` varchar(255) DEFAULT '' COMMENT '发帖人',
  `post_status` int(11) DEFAULT NULL COMMENT '帖子状态',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师编号',
  `teacher_name` varchar(20) NOT NULL,
  `teacher_motto` varchar(50) NOT NULL COMMENT '教师座右铭',
  `teacher_tel` char(11) NOT NULL COMMENT '教师电话',
  `teacher_email` varchar(15) NOT NULL COMMENT '教师邮箱',
  `teacher_desc` varchar(50) DEFAULT NULL COMMENT '教师介绍',
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `user_information`
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_phone` char(11) NOT NULL,
  `user_sex` char(2) NOT NULL,
  `user_description` varchar(100) DEFAULT NULL,
  `user_truename` varchar(20) NOT NULL,
  `user_status` int(11) NOT NULL COMMENT '用户状态',
  PRIMARY KEY (`user_id`),
  KEY `user_phone` (`user_phone`),
  KEY `user_id` (`user_account`),
  KEY `user_truename` (`user_truename`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_information
-- ----------------------------
INSERT INTO `user_information` VALUES ('1', 'zhangjianshun', 'growthbar', '15208316895', '1', '萨达多大大多', '张健顺', '1');
INSERT INTO `user_information` VALUES ('2', 'zhangjianshun', 'growthbar', '15208316895', '1', '萨达多大大多', '张健顺', '1');
