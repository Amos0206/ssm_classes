package com.zc.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 16:45
 * @desc
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //实现登录拦截功能
        //1. 访问首页登录请求【过滤不需要用户登录，就能访问的页面】
        List<String> list = new ArrayList<>();
        list.add("/user/login");

        //2.判断请求中是否包含
        String realUrl = request.getContextPath();
        for(String url:list){
            if(realUrl.contains(url)){
                return true;
            }
        }

        //3.判断用户是否登录
        HttpSession session = request.getSession();
        if(session.getAttribute("userInfo") != null){
            return true;
        }

        //4,页面跳转
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
        return true;
    }
}
