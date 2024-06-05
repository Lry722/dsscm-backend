package cn.dsscm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dsscm.dao.ProductCategoryMapper;
import cn.dsscm.dao.ProductMapper;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ProductCategoryService;
import cn.dsscm.vo.ProductCategoryNested;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductMapper productMapper;

    @Override
    public List<ProductCategoryNested> getList() {
        return productCategoryMapper.selectList();
    }

    @Override
    public void add(ProductCategory category) {
        productCategoryMapper.insert(category);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        ProductCategory category = productCategoryMapper.select(id);
        if (category.getLevel() == 3) {
            int count = productMapper.selectCountByCategory(category.getId());
            if (count > 0) {
                throw new RuntimeException(category.getName() + "分类下有商品，无法删除");
            }
        } else {
            List<Integer> children = productCategoryMapper.selectChildren(category.getId());
            children.forEach((child) -> delete(child));
        }
        productCategoryMapper.delete(category.getId());
    }

    @Override
    public ProductCategory get(Integer id) {
        return productCategoryMapper.select(id);
    }
}
