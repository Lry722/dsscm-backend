-- Active: 1716036990610@@127.0.0.1@3306@dsscm
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8;

INSERT INTO `role` (`id`, `name`) VALUES (1, '超级管理员'), (2, 'test');

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
    `role_id` INT(10) NOT NULL COMMENT '角色ID',
    `name` VARCHAR(16) NOT NULL COMMENT '权限名',
    `value` INT(4) NOT NULL COMMENT '权限值'
);

INSERT INTO
    `permission` (`role_id`, `name`, `value`)
VALUES (1, 'product', 15),
    (1, 'bill', 15),
    (1, 'order', 15),
    (1, 'provider', 15),
    (1, 'user', 15),
    (1, 'role', 15),
    (1, 'message', 15),
    (2, 'product', 15),
    (2, 'bill', 15),
    (2, 'order', 15),
    (2, 'provider', 15),
    (2, 'user', 15),
    (2, 'role', 15),
    (2, 'message', 15);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `account` varchar(16) COLLATE utf8_unicode_ci NOT NULL COMMENT '账号',
    `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码(BCrypt加密)',
    `name` varchar(16) COLLATE utf8_unicode_ci NOT NULL COMMENT '姓名',
    `gender` ENUM('女', '男') DEFAULT NULL COMMENT '性别',
    `birthday` date DEFAULT NULL COMMENT '出生日期',
    `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
    `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
    `address` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
    `description` text COMMENT '简介',
    `role` int(10) DEFAULT NULL COMMENT '用户角色ID',
    `photo` varchar(36) DEFAULT NULL COMMENT '用户照片 UUID',
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 2 DEFAULT CHARSET = utf8;

INSERT INTO
    `user` (
        `id`,
        `account`,
        `password`,
        `name`,
        `role`
    )
VALUES (
        1,
        'admin',
        '$2y$05$vSXrMCHgwCbHkiqpJ7bdVuGknS9rY7.kmGvsBQylT5FkKBeEDbkK6',
        '超级管理员',
        1
    );