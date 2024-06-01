INSERT INTO `role` (`id`, `name`) VALUES (1, '超级管理员'), (2, '采购部员工');

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
        '0',
        '2003-07-22',
        '958515687@qq.com',
        '13850894959',
        2
    ),
    (
        3,
        'testUser3',
        '$2a$10$BntspJxvjMJVFKhw55S7Ce6Uny4YqNmhLnR.2b.jTWbK.H3lcV1Di',
        '测试用户三',
        '1',
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
        '0',
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
        '1',
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
        '0',
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
        '1',
        '2001-04-20',
        'fictional7@example.co.uk',
        '13477778888',
        2
    );

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
    (13, '叶类蔬菜', 10, 3),
    (14, '猪肉', 11, 3),
    (15, '牛肉', 11, 3);

INSERT INTO
    `product` (
        `name`,
        `description`,
        `price`,
        `unit`,
        `placement`,
        `stock`,
        `category_level1`,
        `category_level2`,
        `category_level3`,
        `created_by`,
        `modified_by`
    )
VALUES (
        'iPhone 13 Pro',
        '苹果公司最新旗舰手机，配备强大的A15芯片，超视网膜XDR显示屏。',
        7999.99,
        '部',
        'A区1号货架',
        100.00,
        1,
        2,
        4,
        1,
        1
    ),
    (
        'MacBook Pro 16',
        '高性能笔记本，搭载M1 Pro芯片，适合专业级视频编辑和编程。',
        14999.99,
        '台',
        'B区2号货架',
        50.00,
        1,
        3,
        6,
        1,
        1
    ),
    (
        'Mate 50 Pro',
        '华为高端智能手机，拥有出色的摄影能力和HarmonyOS操作系统。',
        6999.99,
        '部',
        'C区3号货架',
        80.00,
        1,
        2,
        5,
        1,
        1
    ),
    (
        'ThinkPad X1 Carbon',
        '轻薄商务笔记本，适合商务人士，长续航与高效能并存。',
        9999.99,
        '台',
        'D区4号货架',
        30.00,
        1,
        3,
        7,
        1,
        1
    ),
    (
        '芒果',
        '新鲜进口芒果，口感香甜多汁，营养丰富。',
        15.99,
        '斤',
        '生鲜区A架',
        200.00,
        8,
        9,
        12,
        1,
        1
    ),
    (
        '菠菜',
        '有机种植菠菜，富含铁质和维生素，健康绿色。',
        3.99,
        '斤',
        '蔬菜区B架',
        150.00,
        8,
        10,
        13,
        1,
        1
    ),
    (
        '五花肉',
        '优质五花肉，适于红烧、烧烤，肉质鲜美。',
        25.50,
        '斤',
        '冷冻区C架',
        100.00,
        8,
        11,
        14,
        1,
        1
    ),
    (
        '蓝莓',
        '天然野生蓝莓，小果实大营养，抗氧化之王。',
        29.99,
        '斤',
        '精品水果区A1',
        80.00,
        8,
        9,
        12,
        1,
        1
    ),
    (
        '西兰花',
        '精选西兰花，绿色健康，富含膳食纤维。',
        4.49,
        '斤',
        '有机蔬菜区B2',
        200.00,
        8,
        10,
        13,
        1,
        1
    )

INSERT INTO
    `provider` (
        `code`,
        `name`,
        `description`,
        `contact`,
        `phone`,
        `address`,
        `fax`,
        `created_by`,
        `modified_by`
    )
VALUES (
        'ELEC-SP',
        '电子商品供应商',
        '专业提供各类电子产品',
        '联系人甲',
        '10100000001',
        '深圳华强北',
        '0755-12345678',
        1,
        1
    ),
    (
        'FOOD-SP',
        '食品供应商',
        '提供各类新鲜食品',
        '联系人乙',
        '10100000002',
        '北京新发地',
        '010-12345678',
        1,
        1
    );

INSERT INTO
    `bill` (
        `code`,
        `product`,
        `quantity`,
        `total_price`,
        `paid`,
        `provider`,
        `created_by`,
        `modified_by`
    )
VALUES (
        'BILL-E1',
        1,
        1,
        7999.99,
        1,
        1,
        1,
        1
    ), -- iPhone 13 Pro
    (
        'BILL-E2',
        2,
        1,
        14999.99,
        0,
        1,
        1,
        1
    ), -- MacBook Pro 16
    (
        'BILL-E3',
        3,
        1,
        6999.99,
        1,
        1,
        1,
        1
    ), -- Mate 50 Pro
    (
        'BILL-E4',
        4,
        1,
        9999.99,
        1,
        1,
        1,
        1
    ), -- ThinkPad X1 Carbon
    (
        'BILL-F1',
        5,
        3,
        15.99,
        1,
        2,
        1,
        1
    ), -- 芒果
    (
        'BILL-F2',
        6,
        0.5,
        3.99,
        1,
        2,
        1,
        1
    ), -- 菠菜
    (
        'BILL-F3',
        7,
        2,
        25.50,
        1,
        2,
        1,
        1
    ), -- 五花肉
    (
        'BILL-F4',
        8,
        2.5,
        29.99,
        0,
        2,
        1,
        1
    ) -- 蓝莓

INSERT INTO
    `order` (
        `serial_number`,
        `customer_name`,
        `customer_phone`,
        `customer_address`,
        `product`,
        `quantity`,
        `total_price`,
        `payment_type`,
        `status`,
        `created_by`,
        `modified_by`
    )
VALUES (
        'ORDE-E1',
        '顾客一',
        '13000000000',
        '北京市海淀区',
        1,
        1,
        7999.99,
        1,
        4,
        1,
        1
    ),
    (
        'ORDE-E2',
        '顾客二',
        '13000000001',
        '上海市浦东新区',
        2,
        1,
        14999.99,
        2,
        3,
        1,
        1
    ),
    (
        'ORDE-E3',
        '顾客三',
        '13000000002',
        '广州市天河区',
        3,
        2,
        13999.98,
        0,
        2,
        1,
        1
    ), -- 假设顾客三购买了两部Mate 50 Pro
    (
        'ORDE-E4',
        '顾客四',
        '13000000003',
        '深圳市南山区',
        4,
        1,
        9999.99,
        1,
        1,
        1,
        1
    ),
    (
        'ORDE-F1',
        '顾客五',
        '13000000004',
        '北京市朝阳区',
        5,
        5,
        79.95,
        1,
        4,
        1,
        1
    ), -- 假设顾客五购买了5斤芒果
    (
        'ORDE-F2',
        '顾客六',
        '13000000005',
        '上海市徐汇区',
        6,
        10,
        39.9,
        1,
        4,
        1,
        1
    ), -- 假设顾客六购买了10斤菠菜
    (
        'ORDE-F3',
        '顾客七',
        '13000000006',
        '广州市白云区',
        7,
        3,
        76.5,
        0,
        2,
        1,
        1
    ), -- 假设顾客七购买了3斤五花肉
    (
        'ORDE-F4',
        '顾客八',
        '13000000007',
        '深圳市宝安区',
        8,
        2,
        59.98,
        2,
        3,
        1,
        1
    ) -- 假设顾客八购买了2斤蓝莓