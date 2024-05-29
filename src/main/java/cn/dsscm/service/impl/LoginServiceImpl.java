package cn.dsscm.service.impl;

import org.springframework.stereotype.Service;

import cn.dsscm.dto.LoginQuery;
import cn.dsscm.service.LoginService;
import cn.dsscm.service.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{
    private final UserService userService;

    @Override
    public boolean login(LoginQuery loginQuery) {
        return userService.checkPassword(loginQuery.getAccount(), loginQuery.getPassword());
    }
    
}
