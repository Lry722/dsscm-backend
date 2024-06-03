package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.dto.PageInfo;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ImageService;
import cn.dsscm.service.ProductCategoryService;
import cn.dsscm.service.ProductService;
import cn.dsscm.vo.ProductCategoryNested;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;
    private final ImageService imageService;

    @GetMapping("/list")
    public Result<List<Product>> getProductList() {
        return Result.success(productService.getAllList());
    }

    @GetMapping
    public Result<PageInfo<Product>> queryProductList(ProductQuery productQuery) {
        return Result.success(productService.getList(productQuery));
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return Result.success();
    }

    @GetMapping("/categories")
    public Result<List<ProductCategoryNested>> getCategoryList() {
        return Result.success(productCategoryService.getList());
    }

    @PostMapping("/categories")
    public Result<Integer> addCategory(@RequestBody ProductCategory category) {
        productCategoryService.add(category);
        return Result.success(category.getId());
    }
    
    @DeleteMapping("/categories/{id}")
    public Result<Void> deleteCategory(@PathVariable Integer id) {
        productCategoryService.delete(id);
        return Result.success();
    }

    @GetMapping("/photo/{id}")
    public byte[] getPhoto(@PathVariable Integer id) throws IOException {
        String photoFilename = productService.getPhotoFilename(id);
        if (photoFilename != null && !photoFilename.isEmpty()) {
            return imageService.get("product-photo", photoFilename);
        } else {
            return imageService.get("product-photo", "default.jpg");
        }
    }
}
