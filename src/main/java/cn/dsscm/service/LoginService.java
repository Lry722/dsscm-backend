package cn.dsscm.service;

import cn.dsscm.dto.LoginQuery;

public interface LoginService {
    public boolean login(LoginQuery loginQuery);
}
