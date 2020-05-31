/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.66
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 192.168.3.66:3306
 Source Schema         : withjpa

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 31/05/2020 23:01:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name_zh` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, 'ROLE_admin', '管理员');
INSERT INTO `t_role` VALUES (2, 'ROLE_user', '普通用户');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, b'1', b'1', b'1', b'1', '$2a$10$gy0Zi/iW0LLd3XrkBte3Nu3asBikoqL791fsUN06sMCsxj6zwVzoO', 'admin');
INSERT INTO `t_user` VALUES (2, b'1', b'1', b'1', b'1', '$2a$10$JnJzaOMOs7Me2ifFE287Su99H05rx9XOkApfBTRF56zY3ldHRRHHq', 'yinlz');

-- ----------------------------
-- Table structure for t_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `t_user_roles`;
CREATE TABLE `t_user_roles`  (
  `t_user_id` bigint(0) NOT NULL,
  `roles_id` bigint(0) NOT NULL,
  INDEX `FKj47yp3hhtsoajht9793tbdrp4`(`roles_id`) USING BTREE,
  INDEX `FK7l00c7jb4804xlpmk1k26texy`(`t_user_id`) USING BTREE,
  CONSTRAINT `FK7l00c7jb4804xlpmk1k26texy` FOREIGN KEY (`t_user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKj47yp3hhtsoajht9793tbdrp4` FOREIGN KEY (`roles_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_roles
-- ----------------------------
INSERT INTO `t_user_roles` VALUES (1, 1);
INSERT INTO `t_user_roles` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
