package cn.dsscm.service.impl;

import java.util.List;

import cn.dsscm.dao.UserMapper;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public List<User> getList(UserQuery userQuery) {
        return userMapper.selectList(userQuery);
    }

}
