package cn.dsscm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.vo.UserInfo;

@Mapper
public interface UserMapper {

    List<UserInfo> selectList(UserQuery userQuery);

    UserInfo selectById(Integer id);

    UserInfo selectByAccount(String account);
}
