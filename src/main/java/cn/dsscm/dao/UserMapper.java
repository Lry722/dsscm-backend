package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.vo.UserInfo;

public interface UserMapper {

    List<UserInfo> selectList(UserQuery userQuery);

    UserInfo selectById(Integer id);

    UserInfo selectByAccount(String account);
}
