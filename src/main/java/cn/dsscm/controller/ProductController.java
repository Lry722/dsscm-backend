package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public Result<List<ProductCategory>> getCategoryList() {
        return Result.success(productCategoryService.getList());
    }
    
}
