package cn.dsscm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;

import cn.dsscm.dao.ProductMapper;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;
import cn.dsscm.service.ProductService;
import cn.dsscm.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;

    @Override
    public PageInfo<Product> getList(ProductQuery productQuery) {
        Page<Product> page = productQuery.startPage();
        productMapper.selectList(productQuery);
        return new PageInfo<>(page);
    }

    @Override
    public void deleteProduct(Integer id) {
        productMapper.delete(id, (Integer) ThreadLocalUtil.get("userId"));
    }

    @Override
    public List<Product> getAllList() {
        return productMapper.selectAll();
    }

    @Override
    public String getPhotoFilename(Integer id) {
        return productMapper.selectPhotoFilename(id);
    }

    @Override
    public Integer count() {
        return productMapper.selectCount();
    }
    
}
