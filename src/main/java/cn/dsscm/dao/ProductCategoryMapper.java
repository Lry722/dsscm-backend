package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.dsscm.pojo.ProductCategory;

@Mapper
public interface ProductCategoryMapper {
    public List<ProductCategory> selectList();
}
