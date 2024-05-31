package cn.dsscm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.dsscm.dao.ProductMapper;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;
import cn.dsscm.service.ProductService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    @Override
    public List<Product> getList(ProductQuery param) {
        return productMapper.selectList(param);
    }
    
}
