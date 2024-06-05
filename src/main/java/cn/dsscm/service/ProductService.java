package cn.dsscm.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;

public interface ProductService {

    PageInfo<Product> getList(ProductQuery param);

    void deleteProduct(Integer id);

    List<Product> getAllList();

    String getPhotoFilename(Integer id);

    Integer count();

    Product get(Integer id);

    void insert(Product product, MultipartFile photo) throws IllegalStateException, IOException;

    void update(Product product, MultipartFile photo) throws IllegalStateException, IOException;
    
}
