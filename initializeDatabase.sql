-- Active: 1716036990610@@127.0.0.1@3306@dsscm
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` VARCHAR(16) DEFAULT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 2;

INSERT INTO `role` (`id`, `name`) VALUES (1, '超级管理员'), (2, '采购部员工');

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
    `role_id` INT(10) NOT NULL COMMENT '角色ID',
    `name` VARCHAR(16) NOT NULL COMMENT '目标名',
    `value` INT(4) NOT NULL COMMENT '权限值，四位分别代表对目标的增删改查权限',
    KEY `role_index` (`role_id`, `name`)
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
    (2, 'product', 8),
    (2, 'bill', 15),
    (2, 'order', 8),
    (2, 'provider', 8),
    (2, 'user', 0),
    (2, 'role', 0),
    (2, 'message', 8);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `account` VARCHAR(16) UNIQUE NOT NULL COMMENT '账号',
    `password` VARCHAR(60) NOT NULL COMMENT '密码(BCrypt加密)',
    `name` VARCHAR(16) NOT NULL COMMENT '姓名',
    `gender` ENUM('F', 'M') DEFAULT NULL COMMENT '性别',
    `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
    `phone` VARCHAR(15) DEFAULT NULL COMMENT '手机',
    `address` VARCHAR(30) DEFAULT NULL COMMENT '地址',
    `birthday` DATE DEFAULT NULL COMMENT '出生日期',
    `role` INT(10) DEFAULT NULL COMMENT '角色',
    `description` TEXT COMMENT '简介',
    `photo` VARCHAR(42) UNIQUE DEFAULT NULL COMMENT '用户照片 UUID加扩展名',
    PRIMARY KEY (`id`)
) AUTO_INCREMENT = 2;

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

INSERT INTO
    `user` (
        `id`,
        `account`,
        `password`,
        `name`,
        `gender`,
        `birthday`,
        `email`,
        `phone`,
        `role`
    )
VALUES (
        2,
        'lry722',
        '$2y$05$vSXrMCHgwCbHkiqpJ7bdVuGknS9rY7.kmGvsBQylT5FkKBeEDbkK6',
        '林容宇',
        'M',
        '2003-07-22',
        '958515687@qq.com',
        '13850894959',
        2
    );