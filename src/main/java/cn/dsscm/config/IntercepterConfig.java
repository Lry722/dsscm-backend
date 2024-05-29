package cn.dsscm.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.dsscm.interceptor.LoginCheckInterceptor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IntercepterConfig extends WebMvcConfigurationSupport {
    private final LoginCheckInterceptor loginCheckInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login",
                "/static/**");
        super.addInterceptors(registry);
    }
}
