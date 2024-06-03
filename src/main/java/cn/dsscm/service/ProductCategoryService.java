package cn.dsscm.service;

import java.util.List;

import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.vo.ProductCategoryNested;

public interface ProductCategoryService {

    List<ProductCategoryNested> getList();

    void add(ProductCategory category);

    void delete(Integer id);
    
}
