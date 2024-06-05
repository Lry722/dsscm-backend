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

    @Update("UPDATE provider SET deleted = 1, modifiedBy = #{modifiedBy} WHERE id = #{id}")
    void delete(Integer id, Integer modifiedBy);

    @Select("SELECT * FROM provider WHERE id = #{id}")
    Provider select(Integer id);

    @Select("SELECT * FROM provider")
    List<Provider> selectAll();

    @Select("SELECT COUNT(*) FROM provider WHERE deleted = 0")
    Integer selectCount();

    void insert(Provider provider);

    void update(Provider provider);

    @Select("SELECT company_licence_picture FROM provider WHERE id = #{id}")
    String selectCompanyLicencePicture(Integer id);

    @Select("SELECT organization_code_picture FROM provider WHERE id = #{id}")
    String selectOrganizationCodePicture(Integer id);
}
