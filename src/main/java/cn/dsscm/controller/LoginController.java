package cn.dsscm.controller;

import org.springframework.web.bind.annotation.RestController;

import cn.dsscm.common.Result;
import cn.dsscm.dto.LoginQuery;
import cn.dsscm.service.LoginService;
import cn.dsscm.service.UserService;
import cn.dsscm.utils.TokenUtil;
import cn.dsscm.vo.UserInfo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;
    private final UserService userService;
    private final TokenUtil tokenUtil;

    @Value("${token.expire}")
    private Integer expire;
    @Value("${token.max-expire}")
    private Integer maxExpire;

    @PostMapping()
    public Result<Void> login(HttpServletResponse response, @RequestBody LoginQuery loginQuery) {
        boolean success = loginService.login(loginQuery);
        if (success) {
            UserInfo userInfo = userService.getByAccount(loginQuery.getAccount());
            log.info("登录成功，用户信息：{}", userInfo);
            Date maxExpireAt = new Date(System.currentTimeMillis() + maxExpire * 1000);
            Date expireAt = loginQuery.isRememberMe() ? maxExpireAt : new Date(System.currentTimeMillis() + expire * 1000);
            String token = tokenUtil.getToken(userInfo.getId(), expireAt, maxExpireAt);
            Cookie tokenCookie = new Cookie("token", token);
            Cookie userIdCookie = new Cookie("userId", userInfo.getId().toString());
            Cookie userNameCookie = new Cookie("userName", userInfo.getName());
            tokenCookie.setMaxAge(maxExpire);
            userIdCookie.setMaxAge(maxExpire);
            userNameCookie.setMaxAge(maxExpire);
            response.addCookie(tokenCookie);
            response.addCookie(userIdCookie);
            response.addCookie(userNameCookie);

            return Result.success();
        } else {
            return Result.error(401, "用户名或密码错误");
        }
    }
}
