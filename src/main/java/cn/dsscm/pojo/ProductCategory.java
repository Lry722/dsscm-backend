package cn.dsscm.pojo;

import lombok.Data;

@Data
public class ProductCategory {
    private Integer id;
    private String name;
    private Integer parent;
    private Integer level;
}
