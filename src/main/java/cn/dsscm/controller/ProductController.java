package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ProductCategoryService;
import cn.dsscm.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    @GetMapping()
    public Result<List<Product>> getProductList(@RequestBody(required = false) ProductQuery param) {
        return Result.success(productService.getList(param));
    }
    

    @GetMapping("/categories")
    public Result<List<ProductCategory>> getCategoryList() {
        return Result.success(productCategoryService.getList());
    }
    
}
