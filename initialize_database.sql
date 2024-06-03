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
        `count`,
        `total_price`,
        `payment_type`,
        `status`,
        `created_by`,
        `modified_by`
    )
VALUES (
        'ORD001',
        '张三',
        '13800000000',
        '北京市海淀区',
        2,
        22999.98,
        1,
        1,
        1,
        1
    ),
    (
        'ORD002',
        '李四',
        '13900000000',
        '上海市浦东新区',
        1,
        7999.99,
        0,
        0,
        1,
        1
    ),
    (
        'ORD003',
        '王五',
        '13700000000',
        '广州市天河区',
        3,
        15031.96,
        2,
        2,
        1,
        1
    ),
    (
        'ORD004',
        '赵六',
        '13500000000',
        '深圳市南山区',
        1,
        14999.99,
        1,
        0,
        1,
        1
    ),
    (
        'ORD005',
        '孙七',
        '13600000000',
        '杭州市西湖区',
        2,
        8029.98,
        2,
        0,
        1,
        1
    ),
    (
        'ORD006',
        '周八',
        '13711111111',
        '成都市武侯区',
        1,
        3.99,
        1,
        0,
        1,
        1
    ),
    (
        'ORD007',
        '吴九',
        '13822222222',
        '苏州市工业园区',
        4,
        40275.48,
        0,
        0,
        1,
        1
    ),
    (
        'ORD008',
        '郑十',
        '13933333333',
        '西安市雁塔区',
        2,
        7029.98,
        2,
        0,
        1,
        1
    );


INSERT INTO
    `order_to_products` (
        `order_id`,
        `product_id`,
        `quantity`,
        `total_price`
    )
VALUES (1, 1, 1, 7999.99),
    (1, 2, 1, 14999.99),
    (2, 1, 1, 7999.99),
    (3, 1, 1, 7999.99),
    (3, 3, 1, 6999.99),
    (3, 5, 2, 31.98),
    (4, 2, 1, 14999.99),
    (5, 1, 1, 7999.99),
    (5, 8, 1, 29.99),
    (6, 6, 1, 3.99),
    (7, 1, 1, 7999.99),
    (7, 2, 1, 14999.99),
    (7, 4, 1, 9999.99),
    (7, 7, 1, 25.50),
    (8, 3, 1, 6999.99),
    (8, 8, 1, 29.99);
