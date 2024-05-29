package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.vo.UserInfo;

@Mapper
public interface UserMapper {

    public List<UserInfo> selectList(UserQuery userQuery);

    @Select("SELECT * FROM user WHERE id = #{id}")
    public UserInfo selectById(Integer id);

    @Select("SELECT * FROM user WHERE account = #{account}")
    public UserInfo selectByAccount(String account);

    @Select("SELECT photo FROM user WHERE id = #{id}")
    public String selectPhoto(Integer id);

    @Select("SELECT password FROM user WHERE account = #{account}")
    public String selectPassword(String account);

    public void update(User user);

    public void insert(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    public void delete(Integer id);
}
