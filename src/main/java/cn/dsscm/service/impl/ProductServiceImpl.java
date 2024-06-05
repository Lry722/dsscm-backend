package cn.dsscm.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;

import cn.dsscm.dao.ProductMapper;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;
import cn.dsscm.service.ImageService;
import cn.dsscm.service.ProductService;
import cn.dsscm.utils.ThreadLocalUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper productMapper;
    private final ImageService imageService;

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
        return productMapper.selectPhoto(id);
    }

    @Override
    public Integer count() {
        return productMapper.selectCount();
    }

    @Override
    public Product get(Integer id) {
        return productMapper.select(id);
    }

    @Override
    public void insert(Product product, MultipartFile photo) throws IllegalStateException, IOException {
        if (photo != null && photo.getContentType().equals("image/jpeg")) {
            String filename = imageService.upload("product-photo", photo);
            product.setPhoto(filename);
        }
        product.setCreatedBy((Integer) ThreadLocalUtil.get("userId"));
        productMapper.insert(product);
    }

    @Override
    public void update(Product product, MultipartFile photo) throws IllegalStateException, IOException {
        String originPhotoFilename = productMapper.selectPhoto(product.getId());
        if (photo != null) {
            if (photo.getContentType().equals("image/jpeg")) {
                if (originPhotoFilename != null && !originPhotoFilename.isEmpty()) {
                    imageService.delete("product-photo", originPhotoFilename);
                }
                String photoFilename = imageService.upload("product-photo", photo);
                product.setPhoto(photoFilename);
            }
        } else {
            if (originPhotoFilename != null && !originPhotoFilename.isEmpty()) {
                imageService.delete("product-photo", originPhotoFilename);
            }
            product.setPhoto("");
        }
        product.setModifiedBy((Integer) ThreadLocalUtil.get("userId"));
        productMapper.update(product);
    }
}
