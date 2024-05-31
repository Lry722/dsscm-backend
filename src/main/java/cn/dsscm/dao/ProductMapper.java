package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;

@Mapper
public interface ProductMapper {
    public List<Product> selectList(ProductQuery queryParam);
}
