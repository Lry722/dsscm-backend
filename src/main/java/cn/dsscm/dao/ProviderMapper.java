package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.dsscm.dto.ProviderQuery;
import cn.dsscm.pojo.Provider;

@Mapper
public interface ProviderMapper {

    List<Provider> selectList(ProviderQuery queryParams);

    @Update("UPDATE provider SET deleted = 1 WHERE id = #{id}")
    void delete(Integer id);

    @Select("SELECT * FROM provider")
    List<Provider> selectAll();

    @Select("SELECT COUNT(*) FROM provider WHERE deleted = 0")
    Integer selectCount();
    
}
