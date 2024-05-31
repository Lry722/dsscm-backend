package cn.dsscm.service;

import java.util.List;

import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;

public interface ProductService {

    List<Product> getList(ProductQuery param);
    
}
