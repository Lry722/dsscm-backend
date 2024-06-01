package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.dsscm.dto.ProductQuery;
import cn.dsscm.pojo.Product;

@Mapper
public interface ProductMapper {
    public List<Product> selectList(ProductQuery queryParam);

    @Update("UPDATE product SET deleted = 1, modified_by = #{modifiedBy} WHERE id = #{id}")
    public void delete(Integer id, Integer modifiedBy);

    @Select("SELECT * FROM product")
    public List<Product> selectAll();

    @Select("SELECT photo FROM product WHERE id = #{id}")
    public String selectPhotoFilename(Integer id);
}
