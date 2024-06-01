package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;

@Mapper
public interface ProductMapper {
    public List<Product> selectList(ProductQuery queryParam);

    @Update("UPDATE product SET deleted = 1, modified_by = #{modifiedBy} WHERE id = #{id}")
    public void delete(Integer id, Integer modifiedBy);
}
