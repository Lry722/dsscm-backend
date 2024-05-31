package cn.dsscm.pojo;

import java.util.List;

import lombok.Data;

@Data
public class ProductCategory {
    private Integer id;
    private String name;
    private Integer parent;

    private List<ProductCategory> children;
}
