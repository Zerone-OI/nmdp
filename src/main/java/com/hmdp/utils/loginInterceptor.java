package com.hmdp.utils;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Peilong
 */
public class loginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        //判断ThreadLocal中用户信息是否为空
        if (UserHolder.getUser() == null){
            response.setStatus(401);
            return false;
        }

        return true;
    }

}
