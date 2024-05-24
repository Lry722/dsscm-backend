package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;

public interface UserMapper {

    List<User> selectList(UserQuery userQuery);

}
