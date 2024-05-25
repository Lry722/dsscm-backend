package cn.dsscm.service;

import java.util.List;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.vo.UserInfo;

public interface UserService {

    List<UserInfo> getList(UserQuery userQuery);

    UserInfo getById(Integer id);

    UserInfo getByAccount(String account);
}
