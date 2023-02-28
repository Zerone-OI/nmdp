package com.hmdp.config;

import com.hmdp.utils.loginInterceptor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new loginInterceptor(stringRedisTemplate)).excludePathPatterns(
                "/user/login",
                "/user/code",
                "/blog/host",
                "/shop/**",
                "/shop-type/**",
                "/upload/**",
                "/voucher/**"
        );
    }
}
