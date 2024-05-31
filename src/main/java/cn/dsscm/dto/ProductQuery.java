package cn.dsscm.dto;

import cn.dsscm.pojo.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductQuery extends BaseQuery<Product> {
    private String name;
    private Integer category;
}
