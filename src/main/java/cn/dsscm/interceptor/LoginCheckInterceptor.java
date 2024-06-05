package cn.dsscm.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;

import cn.dsscm.common.Result;
import cn.dsscm.utils.ThreadLocalUtil;
import cn.dsscm.utils.TokenUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginCheckInterceptor implements HandlerInterceptor {
    private final TokenUtil tokenUtil;

    @Value("${token.expire}")
    private Integer expire;
    @Value("${token.max-expire}")
    private Integer maxExpire;

    @SuppressWarnings("unused")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        response.setContentType("application/json;charset=UTF-8");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    // 验证token
                    Map<String, Object> result = tokenUtil.parseToken(cookie.getValue());
                    if (result != null) {
                        Integer userId = (Integer) result.get("userId");
                        Date expireAt = (Date) result.get("expireAt");
                        Date forceExpireAt = (Date) result.get("forceExpireAt");
                        ThreadLocalUtil.set("userId", userId);
                        Long leftTimeSeconds = (expireAt.getTime() - new Date().getTime()) / 1000;
                        if (leftTimeSeconds < 30) {
                            // 若剩余时间不足半小时，刷新token
                            String newToken = tokenUtil.getToken(userId, new Date(System.currentTimeMillis() + expire),
                                    forceExpireAt);
                            cookie.setValue(newToken);
                            cookie.setMaxAge(maxExpire);
                            response.addCookie(cookie);
                        }
                        return true;
                    } else {
                        PrintWriter writer = response.getWriter();
                        writer.write(JSON.toJSONString(Result.error(401, "登陆信息已失效，请重新登陆")));
                        writer.close();
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                        return false;
                    }
                }
            }
        }

        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(Result.error(401, "请先登陆")));
        writer.close();
        return false;
    }
}
