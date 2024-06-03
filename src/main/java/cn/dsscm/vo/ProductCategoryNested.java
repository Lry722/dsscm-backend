package cn.dsscm.vo;

import java.util.List;


import lombok.Data;

@Data
public class ProductCategoryNested {
    private Integer id;
    private String name;
    private Integer parent;

    private List<ProductCategoryNested> children;
}
