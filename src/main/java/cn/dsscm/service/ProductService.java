package cn.dsscm.service;

import java.util.List;

import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;

public interface ProductService {

    PageInfo<Product> getList(ProductQuery param);

    void deleteProduct(Integer id);

    List<Product> getAllList();

    String getPhotoFilename(Integer id);

    Integer count();
    
}
