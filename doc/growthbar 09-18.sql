/*
Navicat MySQL Data Transfer

Source Server         : vince
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : growthbar

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-09-18 08:50:14
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
  `activity_theme` varchar(255) NOT NULL,
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------
INSERT INTO `activity` VALUES ('1', '成长吧交流活动', '二教', '2017-03-14 14:12:23', '0', '张世俊', '成长吧交流活动');
INSERT INTO `activity` VALUES ('2', '525心理健康节', '阳光餐厅门口', '2017-05-25 14:12:23', '0', '成长吧', '525心理健康节');
INSERT INTO `activity` VALUES ('3', '狼人杀', '二教', '2017-03-14 14:12:23', '0', '成长吧', '狼人杀');
INSERT INTO `activity` VALUES ('4', '团队活动', '二教', '2017-03-14 14:12:23', '0', '成长吧', '团队活动');

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
  `user_name` varchar(255) NOT NULL,
  `student_id` bigint(20) NOT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `user_appointment_tel` (`user_tel`),
  KEY `user_activity_id` (`activity_id`),
  CONSTRAINT `activity_id` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('5', '念在天涯，心在咫尺', 'zhangjianshun', '生命里，一些缱绻，无论素净，还是喧哗，都已经被岁月赋予了清喜的味道，一些闲词，或清新，或淡雅，总会在某一个回眸的时刻醉了流年，濡湿了柔软的心，冥冥之中，我们沿着呼唤的风声，终于在堆满落花的秋里，再次重逢，念在天涯，心在咫尺，我相信，一米阳光，才是我们最好的距离。   \n       缘起是诗，缘离是画，这些关于岁月，关于记忆的章节，终会被时光搁置在无法触及的红尘之外，曾经，你我一别经年，可风里，总有一段美丽会与我们不期而遇，一盏琉璃，半杯心悦，端然着那一份醉人的静，这安静行走的流年，总会被过往赋予一份清喜，一份浪漫。\n       或许，习惯了着布衣素颜，让清心若雪，不喜张扬，不畏喧哗，守着一怀自己的素韵安静，在自己心中的半亩桃源，修篱种菊，喜欢与山水相依，与流水对话，让文字的墨香，依附在心灵的每一个角落，也喜欢，在闲时，端坐时光一隅，将一本书读到无字，将一盏茶喝到无味，将一个故事看到流泪.……心染尘香，不须有多少的柔情话语去讲，只要能够念起，便是一份温暖。\n       再打开记忆的栅栏，取一壶往昔，与流年对坐，情有多深，心就有多疼，触不到的可惜，在挥手袖的风里滋养着忧伤，捻一缕清芬，看三千浮华，历历往事，素淡清雅，研一池墨香，植于眉心，相遇如梦，一直充满虔诚的无暇，这个十月，我用满怀的深情，打开文字的苍白，灵动的心事，穿过岁月的轩窗，迎面而来，我未曾离开，为何不见了原来这世间的繁华与葱笼？是时光的无情，还是流年容易沧桑，让所有的一切都如逝水匆匆，去了遥远的天涯？\n        从此，我只想，淡泊一份宁静，让心中盈满诗意，只为赴你早就许下的盟誓，你不来，我怎么会轻易离开？一直，我喜欢叶落的静美，梦想着有一天和你一起看云水长天。我说：我韶华已老，岁月早已沧桑，已习惯了静默着独舞忧伤，然，这一眼凝眸，却注定得一世相随！或许我会静静陪你看一生的细水长流。\n        静默，看一场烟花如何绚烂自己的一生，忽然发现，我的梦想，有些什么已悄然变了，呼出的想念里，夏已调谢，秋已深浓，空气里有雨过的清新，却让秋沾染了好些沧桑的凉。一场花开的邂逅，静美了多少无言的守望？一帘烟雨的轮回，成全了多少天涯的相依？梦里天涯，许多人，终要忘记；许多事，总会随风，那些忧伤和叹息的深夜，依然会被突如其来的喧嚣触痛，我的星月，我的花开，曾经悄然用心铭刻，却也被时光的沙漏，渐渐滤去最初的繁华。\n       我知道，那些关怀，那些温暖，你均是悄悄的给予，既已懂得，何须多言？！就让这份静美，永留心间。感谢岁月赠予我的这一份恩宠，亦感谢你让我途径你生命的四季，陪我走过的这一程山水，那么美。遇见，已是很美。就让我借一程云淡风轻。掬一捧水月在手，沾岁月的花香满衣。慎重在相逢的渡口写下：回忆有你，真是精彩。未来很美，许我和你一起笑对！可好？其实，情早已经入心，不要问，情深缘浅；不要说，相见恨晚。遇见已是很美，我们何须追问那些雨的印记，那些相伴的理由？一直想对你说：如果时光不老，情不会改变，如果你愿，我便放下所有矜持，携一颗琉璃素心，陪你静看一生最美的日落烟霞。', '2017-09-16 17:21:55', '1');
INSERT INTO `article` VALUES ('6', 'dsadasdasd', 'zhangjianshun', 'sssssssssssssssssssssssssssssss\nsssssssssssssssssssssssss\n\nssssssssssssssssssss\n\n\n\nsssssssssssssssssssssssssssss', '2017-09-17 16:55:14', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', 'zhangjianshun', '我爱我电', '2017-09-17 15:09:25', '1', '0');
INSERT INTO `comment` VALUES ('2', '1', 'zhangjianshun', 'sdsad', '2017-09-17 16:03:08', '1', '0');
INSERT INTO `comment` VALUES ('3', '1', 'zhangjianshun', 'asdasd', '2017-09-17 16:19:11', '1', '0');
INSERT INTO `comment` VALUES ('4', '2', 'zhangjianshun', '第一个 沙发', '2017-09-17 16:19:36', '1', '0');
INSERT INTO `comment` VALUES ('5', '3', 'zhangjianshun', '沙发', '2017-09-17 16:24:46', '1', '0');
INSERT INTO `comment` VALUES ('6', '1', 'zhangjianshun', '这是什么评论', '2017-09-17 16:54:12', '1', '0');
INSERT INTO `comment` VALUES ('7', '2', 'zhangjianshun', '第二个沙发', '2017-09-17 16:58:56', '1', '0');
INSERT INTO `comment` VALUES ('8', '5', 'zhangjianshun', '他当然是啊', '2017-09-17 16:59:30', '1', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '在电子科大就读是一种什么样的体验', '在电子科大就读是一种什么样的体验', '2017-9-17 14:43:31', 'zhangjianshun', '1');
INSERT INTO `post` VALUES ('2', '元芳你怎么看', '元芳你怎么看', '2017-09-17 14:54:17', 'zhangjianshun', '1');
INSERT INTO `post` VALUES ('3', '成长吧是个什么组织', '。。。。。。。。', '2017-09-17 16:24:34', 'zhangjianshun', '1');
INSERT INTO `post` VALUES ('4', 'ssss', 'sdasdasdasd', '2017-09-17 16:54:44', 'zhangjianshun', '1');
INSERT INTO `post` VALUES ('5', '张光钰是不是沙河彭于晏', '论....', '2017-09-17 16:59:15', 'zhangjianshun', '1');

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
