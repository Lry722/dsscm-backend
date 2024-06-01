package cn.dsscm.pojo;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
