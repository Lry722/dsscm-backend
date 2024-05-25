package cn.dsscm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.dsscm.dao.UserMapper;
import cn.dsscm.dto.UserQuery;
import cn.dsscm.pojo.User;
import cn.dsscm.service.UserService;
import cn.dsscm.vo.UserInfo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public List<UserInfo> getList(UserQuery userQuery) {
        
        return userMapper.selectList(userQuery);
    }

    @Override
    public UserInfo getById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserInfo getByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

}
