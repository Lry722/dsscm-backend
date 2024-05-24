package cn.dsscm.service;

import java.util.List;

import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;

public interface UserService {

    List<User> getList(UserQuery userQuery);

}
