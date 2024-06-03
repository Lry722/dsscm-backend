package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import cn.dsscm.pojo.ProductCategory;
import cn.dsscm.vo.ProductCategoryNested;

@Mapper
public interface ProductCategoryMapper {
    public List<ProductCategoryNested> selectList();

    @Options(useGeneratedKeys=true, keyProperty="id")
    @Insert("INSERT INTO product_category (parent, name, level) VALUES (#{parent}, #{name}, #{level})")
    public Integer insert(ProductCategory category);

    @Delete("DELETE FROM product_category WHERE id = #{id}")
    public void delete(Integer id);

    @Select("SELECT id FROM product_category WHERE parent = #{id}")
    public List<Integer> selectChildren(Integer id);

    @Select("SELECT * FROM product_category WHERE id = #{id}")
    public ProductCategory select(Integer id);
}
