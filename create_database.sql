-- Active: 1716036990610@@127.0.0.1@3306@dsscm
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` VARCHAR(16) DEFAULT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission` (
    `role_id` INT(10) NOT NULL COMMENT '角色ID',
    `name` VARCHAR(16) NOT NULL COMMENT '目标名',
    `value` INT(4) NOT NULL COMMENT '权限值，四位分别代表对目标的增删改查权限',
    KEY `role_index` (`role_id`, `name`)
);

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `account` VARCHAR(16) UNIQUE NOT NULL COMMENT '账号',
    `password` VARCHAR(60) NOT NULL COMMENT '密码(BCrypt加密)',
    `name` VARCHAR(50) NOT NULL COMMENT '姓名',
    `gender` TINYINT(1) DEFAULT NULL COMMENT '性别',
    `email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
    `phone` VARCHAR(15) DEFAULT NULL COMMENT '手机',
    `address` VARCHAR(30) DEFAULT NULL COMMENT '地址',
    `birthday` DATE DEFAULT NULL COMMENT '出生日期',
    `role` INT(10) DEFAULT NULL COMMENT '角色',
    `description` VARCHAR(255) COMMENT '简介',
    `photo` VARCHAR(42) UNIQUE DEFAULT NULL COMMENT '用户照片 UUID加扩展名',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `product_category`;

CREATE TABLE `product_category` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `parent` INT(10) NOT NULL COMMENT '父分类',
    `level` TINYINT(1) NOT NULL COMMENT '级别',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `name` VARCHAR(20) NOT NULL COMMENT '名称',
    `description` VARCHAR(255) COMMENT '描述',
    `price` DECIMAL(10, 2) NOT NULL COMMENT '价格',
    `unit` VARCHAR(10) NOT NULL COMMENT '单位',
    `placement` VARCHAR(20) DEFAULT NULL COMMENT '摆放位置',
    `stock` DECIMAL(10, 2) NOT NULL DEFAULT 0 COMMENT '库存',
    -- 虽然可只储存第三级分类，但为了方便查询，将三级分类都进行储存
    `category_level1` INT(10) NOT NULL COMMENT '一级分类',
    `category_level2` INT(10) DEFAULT NULL COMMENT '二级分类',
    `category_level3` INT(10) DEFAULT NULL COMMENT '三级分类',
    `photo` VARCHAR(42) DEFAULT NULL COMMENT '照片文件名',
    -- 订单和账单信息可能会引用历史商品，因此采用逻辑删除
    `deleted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    `created_by` INT(10) NOT NULL COMMENT '创建者',
    `creation_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_by` INT(10) NOT NULL COMMENT '更新者',
    `modification_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `provider`;

CREATE TABLE `provider` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `code` VARCHAR(20) DEFAULT NULL COMMENT '编码',
    `name` VARCHAR(20) DEFAULT NULL COMMENT '名称',
    `description` VARCHAR(255) DEFAULT NULL COMMENT '详细描述',
    `contact` VARCHAR(20) DEFAULT NULL COMMENT '联系人',
    `phone` VARCHAR(20) DEFAULT NULL COMMENT '联系电话',
    `address` VARCHAR(50) DEFAULT NULL COMMENT '地址',
    `fax` VARCHAR(20) DEFAULT NULL COMMENT '传真',
    `companyLicencePicture` VARCHAR(42) DEFAULT NULL COMMENT '企业营业执照文件名',
    `organizationCodePicture` VARCHAR(42) DEFAULT NULL COMMENT '组织机构代码证文件名',
    -- 账单信息可能会引用历史供应商，因此采用逻辑删除
    `deleted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    `created_by` INT(10) NOT NULL COMMENT '创建者',
    `creation_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_by` INT(10) NOT NULL COMMENT '更新者',
    `modification_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `code` VARCHAR(20) UNIQUE NOT NULL COMMENT '账单编码',
    `product` INT(10) NOT NULL COMMENT '商品',
    `quantity` DECIMAL(10, 2) NOT NULL COMMENT '数量',
    -- 商品的金额可能会变，因此不能直接关联商品，而是要保存产生订单时的金额
    `total_price` DECIMAL(10, 2) NOT NULL COMMENT '总金额',
    `paid` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '已支付',
    `provider` INT(10) NOT NULL COMMENT '供应商ID',
    `created_by` INT(10) NOT NULL COMMENT '创建者',
    `creation_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_by` INT(10) NOT NULL COMMENT '更新者',
    `modification_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `serial_number` varchar(255) NOT NULL COMMENT '订单编码',
    `customer_name` varchar(50) DEFAULT NULL COMMENT '顾客姓名',
    `customer_phone` varchar(20) DEFAULT NULL COMMENT '顾客联系电话',
    `customer_address` varchar(255) DEFAULT NULL COMMENT '顾客地址',
    `count` INT NOT NULL COMMENT '商品种类数',
    `total_price` DECIMAL(10, 2) NOT NULL COMMENT '总金额',
    `payment_type` TINYINT(1) DEFAULT NULL COMMENT '付款方式 0-2【当面支付，在线支付，货到付款】',
    `status` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '订单状态 0-4【待审核，审核通过，配货，卖家已发货，已收货】',
    `created_by` INT(10) NOT NULL COMMENT '创建者',
    `creation_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_by` INT(10) NOT NULL COMMENT '更新者',
    `modification_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
)

DROP TABLE IF EXISTS `order_to_products`;

CREATE TABLE `order_to_products` (
    `order_id` INT(10) NOT NULL COMMENT '订单ID',
    `product_id` INT(10) NOT NULL COMMENT '商品ID',
    `quantity` DECIMAL(10, 2) NOT NULL COMMENT '数量',
    -- 商品的金额可能会变，因此不能直接关联商品，而是要保存产生订单时的金额
    `total_price` DECIMAL(10, 2) NOT NULL COMMENT '总金额',
    PRIMARY KEY (`order_id`, `product_id`)
)