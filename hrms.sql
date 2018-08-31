/*
 Navicat Premium Data Transfer

 Source Server         : MySQL-root
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : hrms

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 29/08/2018 17:12:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for db_check
-- ----------------------------
DROP TABLE IF EXISTS `db_check`;
CREATE TABLE `db_check`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考勤表ID',
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名（db_staff）',
  `office_time` time(6) NOT NULL COMMENT '工作时间（由上级规定上班时间，时分秒）',
  `check_day` date NOT NULL COMMENT '签到日期（年月日）（签到点击触发，自动生成）',
  `check_time` time(6) NOT NULL COMMENT '签到时间（时分秒）（签到点击触发，自动生成）',
  `check_case` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考勤情况（早到、迟到、未到、请假）（通过计算时间差，填入相应情况）',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_DBStaff_DBCheck`(`staff_name`) USING BTREE,
  CONSTRAINT `FK_DBStaff_DBCheck` FOREIGN KEY (`staff_name`) REFERENCES `db_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_check
-- ----------------------------
INSERT INTO `db_check` VALUES ('00910b0341cd45d0a7b073573a3ef062', '1', '08:30:00.000000', '2018-08-29', '15:35:27.000000', '迟到', '0');
INSERT INTO `db_check` VALUES ('0c1a080159214f298b26b064cece600f', '1', '08:30:00.000000', '2018-08-23', '08:00:00.000000', '早到', '1');
INSERT INTO `db_check` VALUES ('0c1a080159214f298b26j064cece600f', '021f80100faaf44db61a32a6e9e55a40', '16:53:22.000000', '2018-08-29', '16:53:31.000000', '迟到', '0');
INSERT INTO `db_check` VALUES ('0c1a080159214f298e26b064cece600f', '021f80100faa444db61a32a6e9e55a40', '10:05:21.000000', '2018-08-22', '10:05:31.000000', '迟到', '1');
INSERT INTO `db_check` VALUES ('176696b9345f4f3eb76eca7cf3f4727b', '021f80100faa444db61a32a6e9e55a40', '08:30:00.000000', '2018-08-29', '10:07:23.000000', '迟到', '0');
INSERT INTO `db_check` VALUES ('768c2d5b0f4e4611bc5e12b2af02214c', '021f80100faa444db61a32a6e9e55a40', '08:30:00.000000', '2018-08-29', '13:46:34.000000', '迟到', '1');
INSERT INTO `db_check` VALUES ('cd5ed2bd58bc45c59dd5e52773d82326', '1', '08:30:00.000000', '2018-08-29', '15:55:08.000000', '迟到', '0');
INSERT INTO `db_check` VALUES ('d57b9795f2f24a98a35692ddeac76292', '021f80100faa444db61a32a6e9e55a40', '08:30:00.000000', '2018-08-28', '18:50:02.000000', '迟到', '0');

-- ----------------------------
-- Table structure for db_department
-- ----------------------------
DROP TABLE IF EXISTS `db_department`;
CREATE TABLE `db_department`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门表ID',
  `department_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门职位',
  `duty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职责描述',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_department
-- ----------------------------
INSERT INTO `db_department` VALUES ('021f80100faa444db61a32a6e9e5w540', '技术部', '专员', '网络维护处理', '1');
INSERT INTO `db_department` VALUES ('098609b0891a4245b73df424924b5d0a', '啊啊啊', '', '', '0');
INSERT INTO `db_department` VALUES ('1ac9b25b823c44388d8f89229f0fffa0', '总经理办公室', '总经理', '辅助董事会办公', '0');
INSERT INTO `db_department` VALUES ('1ac9b25b823c44388d8f89229fffffa0', '总经理办公室', '副经理', '辅助总经理办公', '0');
INSERT INTO `db_department` VALUES ('2700889d4b61439a925a842ee37bdc79', '技术部', '主管', '负责技术指导', '1');
INSERT INTO `db_department` VALUES ('29b1af1a6cd94caf8c0826df052c7ce8', '5', '5', '5', '1');
INSERT INTO `db_department` VALUES ('29e1843650de4002ba53e4e368e8aed2', '行政部', '主管', '参与公司行政管理', '0');
INSERT INTO `db_department` VALUES ('2fc1170a5dcc4e60af5203a9e08f82e1', '额', '', '', '1');
INSERT INTO `db_department` VALUES ('32ab259ba17a4700ada53865b60dea89', '财务部', '实习生', '负责财务的核算和整理文档', '0');
INSERT INTO `db_department` VALUES ('459c71f784fa41f982e4460f599a3027', '图', '', '', '1');
INSERT INTO `db_department` VALUES ('46429cea4d0d4f3ab593a8875307cbb5', '董事会', '董事长', '管理公司运作', '0');
INSERT INTO `db_department` VALUES ('4d440eb9a6b344798838f1dde8a8baa0', '啊啊啊', '', '', '0');
INSERT INTO `db_department` VALUES ('548b8dcc588d45babf0517272df38767', '盛源行', '', '', '0');
INSERT INTO `db_department` VALUES ('7cc1a47db47e407aa96ef4df1392546b', '啊啊啊', '', '', '0');
INSERT INTO `db_department` VALUES ('7edcfba284af43189a68db647cf3e262', '124124214', '', '', '0');
INSERT INTO `db_department` VALUES ('84c6b7c8e2c748b68f529603f4c2aeb0', '324234', '', '', '0');
INSERT INTO `db_department` VALUES ('853cc43ee9094998b17ceeec8df77667', '啊啊啊', '', '', '0');
INSERT INTO `db_department` VALUES ('88f3eeee081e422191c7c0f0c41aa6d1', '123123', '', '', '0');
INSERT INTO `db_department` VALUES ('8b08ea5707ff4f5b89b577b6d6e5482a', '1', '1', '1', '0');
INSERT INTO `db_department` VALUES ('91a004f2821e495c8e25c6d45b1ee751', '2', '2', '2', '0');
INSERT INTO `db_department` VALUES ('9e69bf1fcd2c410291815b2113673fa1', '手动阀', '', '', '1');
INSERT INTO `db_department` VALUES ('a5ddf414a42d461f8c0cdda37ba8fd5c', '3', '3', '3', '0');
INSERT INTO `db_department` VALUES ('ab12cb8e2fa549fb8342754868bd18dd', '手动阀', '', '', '1');
INSERT INTO `db_department` VALUES ('c6e87c91047947b4a4f1d8e03c094027', '安慰法', '', '', '1');
INSERT INTO `db_department` VALUES ('cc156cda691049ae8e04cc87784942d7', '手动阀', '', '', '1');
INSERT INTO `db_department` VALUES ('d1a937043a2d47c2a1e4a04eebd86366', '哦', '', '', '1');
INSERT INTO `db_department` VALUES ('d5c31f8c90a34a149a172af24c7b2a9b', '4', '5', '6', '0');
INSERT INTO `db_department` VALUES ('d884789f1b404f8cafd7680b3251e0ac', '啊', '', '', '1');
INSERT INTO `db_department` VALUES ('d8b6a600f0a14037ae90bcc265cb34d2', '14', '14', '', '0');
INSERT INTO `db_department` VALUES ('dbdf992f77ac4fe08f3155425b152366', '468', '', '', '0');
INSERT INTO `db_department` VALUES ('e273f3c8d14c495aafbff5a9fcc84334', '1', '1', '1', '0');
INSERT INTO `db_department` VALUES ('e7d6abac27f540a282e511b0557a5f2d', '135', '', '', '0');
INSERT INTO `db_department` VALUES ('f0effbff3fdf44f0baab916f6491cfad', '8', '', '', '0');
INSERT INTO `db_department` VALUES ('f9caca3284704687ac3aa7fa3313be5e', '品管部', '专员', '辅助主管处理事务', '0');
INSERT INTO `db_department` VALUES ('fa8374f8bfd34ce4993cde4c0e69e388', '9', '', '', '0');

-- ----------------------------
-- Table structure for db_file
-- ----------------------------
DROP TABLE IF EXISTS `db_file`;
CREATE TABLE `db_file`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件表ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名称',
  `file_content` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件内容',
  `post_time` bigint(100) NOT NULL COMMENT '文件上传时间',
  `post_staff` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件上传员工 (db_staff)',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_DBStaff_DBFile`(`post_staff`) USING BTREE,
  CONSTRAINT `FK_DBStaff_DBFile` FOREIGN KEY (`post_staff`) REFERENCES `db_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_file
-- ----------------------------
INSERT INTO `db_file` VALUES ('022cf811e3324758b2513d808c682829', '公告', '明天放假', 1535519279308, '021f80100faaf44db61a32a6e9e55a40', '0');
INSERT INTO `db_file` VALUES ('15e328a554dd4863beeffbd5446663ca', '放假通知', '2018年8月放假通知', 20180510, '021f80100faa444db61a32a6e9e55a40', '1');
INSERT INTO `db_file` VALUES ('21c14bd8ab5543519b926ca93d2c67ba', '年度财务报告', '优', 20180501, '021f80100faaf44db61a32a6e9e55a40', '0');

-- ----------------------------
-- Table structure for db_salary
-- ----------------------------
DROP TABLE IF EXISTS `db_salary`;
CREATE TABLE `db_salary`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工资表ID',
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名（db_staff）',
  `basic_wage` float(30, 0) NOT NULL COMMENT '基础工资',
  `merit_pay` float(30, 0) NOT NULL COMMENT '绩效工资',
  `rewards` float(30, 0) NOT NULL COMMENT '奖惩工资',
  `salary_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工资月份备注',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工资情况备注',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_DBStaff_DBSalary`(`staff_name`) USING BTREE,
  CONSTRAINT `FK_DBStaff_DBSalary` FOREIGN KEY (`staff_name`) REFERENCES `db_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_salary
-- ----------------------------
INSERT INTO `db_salary` VALUES ('0bc0de0435eb4ef7bf97d7c1ab23c5fc', '021f80100faa444db61a32a6e9e55a40', 13123, 12313, 13212, '一月份工资', '无', '1');
INSERT INTO `db_salary` VALUES ('21c14bd8ab5543519b926ca93d2c6736', '021f80100faa444db61a32a6e9e55a40', 2000, 500, -200, '十月份工资', '扣除200', '0');
INSERT INTO `db_salary` VALUES ('4c2f508c604a4e60a13feceffc5078dd', '021f80100faa444db61a32a6e9e55a40', 13585, 2123, 223, '二月份工资', '继续努力', '0');
INSERT INTO `db_salary` VALUES ('5c55a170f1fc4a2ba54b9b41376ba8d3', '021f80100faa444db61a32a6e9e55a40', 13585, 3008, 500, '一月份工资', '干得漂亮', '0');
INSERT INTO `db_salary` VALUES ('64a9997560dc46049eece6ccd4e2afde', '021f80100faa444db61a32a6e9e55a40', 2000, 358, 550, '三月份工资', '乌拉拉', '0');
INSERT INTO `db_salary` VALUES ('67a69fb99bf44a2d87bbd3979c08c950', '021f80100faa444db61a32a6e9e55a40', 12356, 3355, 347, '四月份工资', '哇咔咔', '0');
INSERT INTO `db_salary` VALUES ('7c70d90bad8b41a2850128154c4c6bf6', '021f80100faa444db61a32a6e9e55a40', 5000, 6000, 700, '五月份工资', '飒飒', '0');
INSERT INTO `db_salary` VALUES ('82127f4118df43acb4160ee3f2514628', '021f80100faa444db61a32a6e9e55a40', 15863, 21, 440, '六月份工资', '自动地址', '0');
INSERT INTO `db_salary` VALUES ('8992fba5233f410cb0b61d0d521df4f6', '021f80100faa444db61a32a6e9e55a40', 2000, 1999, 200, '七月份工资', '和粉丝回复', '1');
INSERT INTO `db_salary` VALUES ('8a97ad64d4464f2a82569c727956fe37', '021f80100faa444db61a32a6e9e55a40', 1111, 111, 11, '八月份工资', '萨尔', '0');
INSERT INTO `db_salary` VALUES ('b01b25a6a6894749ac05f4fdc0d7905a', '021f80100faa444db61a32a6e9e55a42', 5000, 3000, 2000, '一月份工资', '长得帅，奖励3000', '1');

-- ----------------------------
-- Table structure for db_staff
-- ----------------------------
DROP TABLE IF EXISTS `db_staff`;
CREATE TABLE `db_staff`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工表ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工性别',
  `age` int(10) NOT NULL COMMENT '员工年龄',
  `place` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '籍贯',
  `birth` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生日',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `staff_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工所属部门 (db_department)',
  `staff_position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工所在职位 (db_department)',
  `entry_time` bigint(100) NOT NULL COMMENT '入职时间',
  `leave_time` bigint(100) NULL DEFAULT NULL COMMENT '离职时间',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_DBStaff_DBDepartment_department`(`staff_department`) USING BTREE,
  INDEX `FK_DBStaff_DBDepartment_position`(`staff_position`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  CONSTRAINT `FK_DBStaff_DBDepartment_department` FOREIGN KEY (`staff_department`) REFERENCES `db_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_DBStaff_DBDepartment_position` FOREIGN KEY (`staff_position`) REFERENCES `db_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_staff
-- ----------------------------
INSERT INTO `db_staff` VALUES ('021f80100faa444db61a32a6e9e55a40', '多俊睿', '男', 16, '广西桂林', '1119', '18178322520', '46429cea4d0d4f3ab593a8875307cbb5', '1ac9b25b823c44388d8f89229f0fffa0', 20180808, 20180815, '1');
INSERT INTO `db_staff` VALUES ('021f80100faa444db61a32a6e9e55a42', '张锐', '男', 11, '广西南宁', '0125', '16855465456', '1ac9b25b823c44388d8f89229fffffa0', '1ac9b25b823c44388d8f89229fffffa0', 20180531, 20200101, '1');
INSERT INTO `db_staff` VALUES ('021f80100faaf44db61a32a6e9e55a40', '吴娜', '男', 12, '广东广州', '20100523', '13335632312', '46429cea4d0d4f3ab593a8875307cbb5', '1ac9b25b823c44388d8f89229f0fffa0', 20180101, NULL, '1');
INSERT INTO `db_staff` VALUES ('1', '黄锦乐', '男', 19, '广西', '191919', '115', 'f9caca3284704687ac3aa7fa3313be5e', '1ac9b25b823c44388d8f89229f0fffa0', 1111, 1111, '1');
INSERT INTO `db_staff` VALUES ('6a934b4236954039a9158acdcfcb0542', '啊啊啊', '女', 1, '1', '111', '1', '46429cea4d0d4f3ab593a8875307cbb5', '46429cea4d0d4f3ab593a8875307cbb5', 111, 11, '0');
INSERT INTO `db_staff` VALUES ('99c370a692c7483fa3d8f76e6eff33dd', '黄锦乐', '男', 1, '1', '1', '1', '46429cea4d0d4f3ab593a8875307cbb5', '1ac9b25b823c44388d8f89229f0fffa0', 1, 1, '0');
INSERT INTO `db_staff` VALUES ('a75e1b39357447448167924cef53b14e', '方箫', '男', 13, '广西', '1102', '15536230103', '46429cea4d0d4f3ab593a8875307cbb5', '1ac9b25b823c44388d8f89229f0fffa0', 20180712, NULL, '0');

-- ----------------------------
-- Table structure for db_transfer
-- ----------------------------
DROP TABLE IF EXISTS `db_transfer`;
CREATE TABLE `db_transfer`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调动表ID',
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名（db_staff）',
  `old_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '原部门名称 (db_department)',
  `new_department` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新部门名称 (db_department)',
  `transfer_time` date NOT NULL COMMENT '调动时间',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_DBTransfer_DBStaff`(`staff_name`) USING BTREE,
  INDEX `FK_DBTransfer_DBDepartment_old`(`old_department`) USING BTREE,
  INDEX `FK_DBTransfer_DBDepartment_new`(`new_department`) USING BTREE,
  CONSTRAINT `FK_DBTransfer_DBDepartment_new` FOREIGN KEY (`new_department`) REFERENCES `db_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_DBTransfer_DBDepartment_old` FOREIGN KEY (`old_department`) REFERENCES `db_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_DBTransfer_DBStaff` FOREIGN KEY (`staff_name`) REFERENCES `db_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_transfer
-- ----------------------------
INSERT INTO `db_transfer` VALUES ('2700889d4b61439a925a842ee37bdc79', '021f80100faa444db61a32a6e9e55a40', '29e1843650de4002ba53e4e368e8aed2', '29e1843650de4002ba53e4e368e8aed2', '2018-08-23', '1');
INSERT INTO `db_transfer` VALUES ('2700889d4b61439a925a842ee37bdc7b', '021f80100faa444db61a32a6e9e55a40', '1ac9b25b823c44388d8f89229fffffa0', '29e1843650de4002ba53e4e368e8aed2', '1970-01-01', '1');
INSERT INTO `db_transfer` VALUES ('74e4bd7b4bc548fe8a1c4fd4a38d90f4', '021f80100faa444db61a32a6e9e55a42', '32ab259ba17a4700ada53865b60dea89', '46429cea4d0d4f3ab593a8875307cbb5', '1970-01-01', '0');

-- ----------------------------
-- Table structure for db_user
-- ----------------------------
DROP TABLE IF EXISTS `db_user`;
CREATE TABLE `db_user`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统账号表ID',
  `staff_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名（db_staff）',
  `user_account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `user_password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号密码',
  `creat_time` datetime(6) NOT NULL COMMENT '创建时间',
  `isdelete` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否删除（0或者空为未删除，1为删除）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_DBUser_DBStaff`(`staff_name`) USING BTREE,
  CONSTRAINT `FK_Dbstaff_DBuser` FOREIGN KEY (`staff_name`) REFERENCES `db_staff` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of db_user
-- ----------------------------
INSERT INTO `db_user` VALUES ('021f80100faa444d261a32a6e9e55a47', '021f80100faaf44db61a32a6e9e55a40', '3', '3', '2018-07-03 15:07:56.000000', '0');
INSERT INTO `db_user` VALUES ('021f80100faa444db61a32a6e9e55a40', '021f80100faa444db61a32a6e9e55a40', '123456', '123456', '2018-08-15 16:52:22.000000', '1');
INSERT INTO `db_user` VALUES ('021f80100faa444db61a32a6e9e55a4k', '021f80100faaf44db61a32a6e9e55a40', '2', '2', '2018-08-08 15:06:34.000000', '1');
INSERT INTO `db_user` VALUES ('021f80100faa444db61a32a6e9e55a54', '021f80100faaf44db61a32a6e9e55a40', '3', '3', '2018-08-15 15:08:22.000000', '0');
INSERT INTO `db_user` VALUES ('1', '021f80100faa444db61a32a6e9e55a42', '1', '1', '2018-08-23 18:05:36.000000', '0');

SET FOREIGN_KEY_CHECKS = 1;
