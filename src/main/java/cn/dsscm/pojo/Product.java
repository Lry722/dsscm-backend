package cn.dsscm.pojo;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// CREATE TABLE `product` (
//     `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
//     `name` VARCHAR(20) NOT NULL COMMENT '名称',
//     `description` TEXT COMMENT '描述',
//     `price` DECIMAL(10, 2) NOT NULL COMMENT '价格',
//     `placement` VARCHAR(30) DEFAULT NULL COMMENT '摆放位置',
//     `stock` DECIMAL(10, 2) NOT NULL COMMENT '库存',
//     `category_level1` INT(10) DEFAULT NULL COMMENT '分类1',
//     `category_level2` INT(10) DEFAULT NULL COMMENT '分类2',
//     `category_level3` INT(10) DEFAULT NULL COMMENT '分类3',
//     `photo` VARCHAR(42) DEFAULT NULL COMMENT '照片文件名',
//     `deleted` TINYINT(1) DEFAULT 0 COMMENT '逻辑删除',
//     `created_by` BIGINT(20) DEFAULT NULL COMMENT '创建者',
//     `creation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
//     `modified_by` BIGINT(20) DEFAULT NULL COMMENT '更新者',
//     `modication_date` DATETIME DEFAULT NULL COMMENT '更新时间',
//     PRIMARY KEY (`id`)
// )
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Product extends AuditableEntity {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String placement;
    private Integer stock;
    private Integer categoryLevel1;
    private Integer categoryLevel2;
    private Integer categoryLevel3;
    private String photo;
    private Integer deleted;
}
