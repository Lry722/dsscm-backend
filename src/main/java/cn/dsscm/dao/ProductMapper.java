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
    public String selectPhoto(Integer id);

    @Select("SELECT COUNT(*) FROM product WHERE deleted = 0")
    public Integer selectCount();

    @Select("SELECT COUNT(*) FROM product WHERE deleted = 0 AND category_level3 = #{id}")
    public int selectCountByCategory(Integer id);

    @Select("SELECT * FROM product WHERE id = #{id}")
    public Product select(Integer id);

    public void insert(Product product);

    public void update(Product product);
}
