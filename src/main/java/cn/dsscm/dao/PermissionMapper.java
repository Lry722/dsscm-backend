package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.dsscm.pojo.Permission;

@Mapper
public interface PermissionMapper {
    @Select("SELECT * FROM permission WHERE role_id = #{roleId}")
    List<Permission> selectByRoleId(Integer roleId);

    @Delete("DELETE FROM permission WHERE role_id = #{roleId}")
    void deleteByRoleId(Integer roleId);

    @Insert("INSERT INTO permission (role_id, name, value) VALUES (#{roleId}, #{name}, #{value})")
    void create(Permission permission);

    @Update("UPDATE permission SET value = #{value} WHERE role_id = #{roleId} AND name = #{name}")
    void update(Permission permission);
}
