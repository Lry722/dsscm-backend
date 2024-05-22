package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.dsscm.pojo.Role;

@Mapper
public interface RoleMapper{
    @Select("SELECT * FROM role WHERE name LIKE '%${name}%'")
    public List<Role> selectByName(String name);

    public List<Role> selectList(String name);

    @Select("SELECT * FROM role WHERE id = #{id}")
    public Role selectById(Integer id);

    @Delete("DELETE FROM role WHERE id = #{id}")
    public void deleteById(Integer id);

    @Options(useGeneratedKeys=true, keyProperty="id")
    @Insert("INSERT INTO role(id, name) VALUES(#{id}, #{name})")
    public Integer create(Role role);

    @Update("UPDATE role SET name = #{name} WHERE id = #{id}")
    public void update(Role role); 
}
