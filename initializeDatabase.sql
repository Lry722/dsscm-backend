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
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '林容宇',
        'M',
        '2003-07-22',
        '958515687@qq.com',
        '13850894959',
        2
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
        3,
        'testUser3',
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '测试用户三',
        'F',
        '1999-03-15',
        'test3@example.com',
        '13700001111',
        2
    ),
    (
        4,
        'demoUser4',
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '演示用户四',
        'M',
        '2000-11-29',
        'demo4@example.org',
        '13611112222',
        2
    ),
    (
        5,
        'sample5',
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '示例用户五',
        'F',
        '2002-07-07',
        'sample5@example.net',
        '13933334444',
        2
    ),
    (
        6,
        'mockUser6',
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '模拟用户六',
        'M',
        '1998-09-18',
        'mock6@example.io',
        '13555556666',
        2
    ),
    (
        7,
        'fictional7',
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '虚构用户七',
        'F',
        '2001-04-20',
        'fictional7@example.co.uk',
        '13477778888',
        2
    );

DROP TABLE IF EXISTS `product_category`;

CREATE TABLE `product_category` (
    `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` varchar(20) NOT NULL COMMENT '名称',
    `parent` int(10) NOT NULL COMMENT '父分类',
    `level` int(11) NOT NULL COMMENT '级别',
    PRIMARY KEY (`id`)
)

INSERT INTO
    `product_category` (
        `id`,
        `name`,
        `parent`,
        `level`
    )
VALUES (1, '电子产品', 0, 1),
    (2, '手机', 1, 2),
    (3, '笔记本电脑', 1, 2),
    (4, '苹果手机', 2, 3),
    (5, '华为手机', 2, 3),
    (6, '游戏本', 3, 3),
    (7, '商务本', 3, 3),
    (8, '生鲜食品', 0, 1),
    (9, '水果', 8, 2),
    (10, '蔬菜', 8, 2),
    (11, '肉类', 8, 2),
    (12, '热带水果', 9, 3),
    (13, '叶类蔬菜', 10, 3)

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `description` TEXT COMMENT '描述',
    `price` DECIMAL(10, 2) NOT NULL COMMENT '价格',
    `placement` VARCHAR(30) DEFAULT NULL COMMENT '摆放位置',
    `stock` DECIMAL(10, 2) NOT NULL COMMENT '库存',
    `category_level1` INT(10) DEFAULT NULL COMMENT '分类1',
    `category_level2` INT(10) DEFAULT NULL COMMENT '分类2',
    `category_level3` INT(10) DEFAULT NULL COMMENT '分类3',
    `photo` VARCHAR(42) DEFAULT NULL COMMENT '照片文件名',
    `deleted` TINYINT(1) DEFAULT 0 COMMENT '逻辑删除',
    `created_by` INT(10) NOT NULL COMMENT '创建者',
    `creation_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_by` INT(10) NOT NULL COMMENT '更新者',
    `modification_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
)

INSERT INTO
    `product` (
        `id`,
        `name`,
        `description`,
        `price`,
        `placement`,
        `stock`,
        `category_level1`,
        `category_level2`,
        `category_level3`,
        `photo`,
        `deleted`,
        `created_by`,
        `creation_time`,
        `modified_by`,
        `modification_time`
    )
VALUES (
        1,
        'iPhone 13 Pro',
        '苹果公司最新旗舰手机，配备强大的A15芯片，超视网膜XDR显示屏。',
        7999.99,
        'A区1号货架',
        100.00,
        1,
        2,
        4,
        'iphone13pro.jpg',
        0,
        123456,
        NOW(),
        123456,
        NOW()
    ),
    (
        2,
        'MacBook Pro 16"',
        '高性能笔记本，搭载M1 Pro芯片，适合专业级视频编辑和编程。',
        14999.99,
        'B区2号货架',
        50.00,
        1,
        3,
        6,
        'macbookpro16.jpg',
        0,
        789012,
        NOW(),
        789012,
        NOW()
    ),
    (
        3,
        'Mate 50 Pro',
        '华为高端智能手机，拥有出色的摄影能力和HarmonyOS操作系统。',
        6999.99,
        'C区3号货架',
        80.00,
        1,
        2,
        5,
        'mate50pro.jpg',
        0,
        13579,
        NOW(),
        13579,
        NOW()
    ),
    (
        4,
        'ThinkPad X1 Carbon',
        '轻薄商务笔记本，适合商务人士，长续航与高效能并存。',
        9999.99,
        'D区4号货架',
        30.00,
        1,
        3,
        7,
        'thinkpadx1carbon.jpg',
        0,
        2468,
        NOW(),
        2468,
        NOW()
    ),
    (
        201,
        '芒果',
        '新鲜进口芒果，口感香甜多汁，营养丰富。',
        15.99,
        '生鲜区A架',
        200.00,
        8,
        9,
        12,
        'mango.jpg',
        0,
        1,
        NOW(),
        1,
        NOW()
    ),
    (
        202,
        '菠菜',
        '有机种植菠菜，富含铁质和维生素，健康绿色。',
        3.99,
        '蔬菜区B架',
        150.00,
        8,
        10,
        13,
        'spinach.jpg',
        0,
        2,
        NOW(),
        2,
        NOW()
    ),
    (
        203,
        '五花肉',
        '优质五花肉，适于红烧、烧烤，肉质鲜美。',
        25.50,
        '冷冻区C架',
        100.00,
        8,
        11,
        14,
        'pork.jpg',
        0,
        3,
        NOW(),
        3,
        NOW()
    ),
    (
        204,
        '蓝莓',
        '天然野生蓝莓，小果实大营养，抗氧化之王。',
        29.99,
        '精品水果区A1',
        80.00,
        8,
        9,
        12,
        'blueberry.jpg',
        0,
        1,
        NOW(),
        1,
        NOW()
    ),
    (
        205,
        '西兰花',
        '精选西兰花，绿色健康，富含膳食纤维。',
        4.49,
        '有机蔬菜区B2',
        200.00,
        8,
        10,
        13,
        'broccoli.jpg',
        0,
        2,
        NOW(),
        2,
        NOW()
    )