package cn.dsscm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.dsscm.common.Result;
import cn.dsscm.dao.ProductCategoryMapper;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryMapper productCategoryMapper;

    @Override
    public List<ProductCategory> getList() {
        return productCategoryMapper.selectList();
    }
    
}
