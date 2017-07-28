/*
Navicat MySQL Data Transfer

Source Server         : vince
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : growthbar

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-07-28 11:31:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `activity`
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(1) NOT NULL COMMENT '活动编号',
  `activity_content` varchar(20) NOT NULL COMMENT '活动内容',
  `activity_place` varchar(255) DEFAULT NULL COMMENT '活动地点',
  `activity_time` int(11) NOT NULL COMMENT '活动时间',
  `status` int(2) NOT NULL COMMENT '活动状态',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for `appointment`
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL COMMENT '预约编号',
  `activity_id` int(1) NOT NULL COMMENT '活动编号',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_croatian_ci NOT NULL COMMENT '用户账号',
  `user_num` int(13) NOT NULL COMMENT '人数',
  `user_tel` char(11) NOT NULL COMMENT '联系方式',
  `status` int(2) NOT NULL COMMENT '预约状态',
  PRIMARY KEY (`appointment_id`),
  KEY `user_appointment_tel` (`user_tel`),
  KEY `user_activity_id` (`activity_id`),
  CONSTRAINT `user_activity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_appointment_tel` FOREIGN KEY (`user_tel`) REFERENCES `user_information` (`user_phone`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of appointment
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', 'title', 'asd', 'content', '1501212650', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL COMMENT '评论编号',
  `post_id` int(11) NOT NULL COMMENT '帖子编号',
  `user_account` varchar(20) NOT NULL COMMENT '用户编号',
  `comment_content` varchar(50) NOT NULL COMMENT '评论内容',
  `comment_time` int(11) NOT NULL COMMENT '评论时间',
  `status` int(2) NOT NULL COMMENT '评论状态',
  PRIMARY KEY (`comment_id`),
  KEY `user_postbar_id` (`user_account`),
  CONSTRAINT `user_postbar_id` FOREIGN KEY (`user_account`) REFERENCES `user_information` (`user_account`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL COMMENT '帖子编号',
  `post_title` varchar(255) NOT NULL COMMENT '帖子标题',
  `post_content` varchar(255) NOT NULL COMMENT '帖子内容',
  `post_time` int(11) NOT NULL COMMENT '发帖时间',
  `user_account` varchar(255) DEFAULT '' COMMENT '发帖人',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL COMMENT '问题编号',
  `question_content` varchar(255) NOT NULL COMMENT '问题内容',
  `question_true_answer` int(1) NOT NULL COMMENT '问题答案',
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for `que_answer`
-- ----------------------------
DROP TABLE IF EXISTS `que_answer`;
CREATE TABLE `que_answer` (
  `que_id` int(11) NOT NULL,
  `one` varchar(30) DEFAULT NULL,
  `two` varchar(30) DEFAULT NULL,
  `three` varchar(30) DEFAULT NULL,
  `four` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`que_id`),
  CONSTRAINT `id` FOREIGN KEY (`que_id`) REFERENCES `question` (`question_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of que_answer
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for `user_information`
-- ----------------------------
DROP TABLE IF EXISTS `user_information`;
CREATE TABLE `user_information` (
  `user_id` int(11) NOT NULL,
  `user_account` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_phone` char(11) NOT NULL,
  `user_sex` int(1) NOT NULL,
  `user_description` varchar(100) DEFAULT NULL,
  `user_truename` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_phone` (`user_phone`),
  KEY `user_id` (`user_account`),
  KEY `user_truename` (`user_truename`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_information
-- ----------------------------
