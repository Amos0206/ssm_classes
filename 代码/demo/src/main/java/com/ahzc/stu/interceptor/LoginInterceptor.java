package com.ahzc.stu.interceptor;

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
 * @date 2021/12/11 15:56
 * @desc
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //实现登录拦截功能
        //1. 访问首页登录请求【过滤不需要用户登录，就能访问的页面】
//        List<String> list = new ArrayList<>();
//        list.add("/index");
//        list.add("/login");
//        list.add("/static/css/*");
//        list.add("/static/js/**");
//        list.add("/static/fonts/**");
//        list.add("/static/images/**");
//        list.add("/static/lib/**");


        //2.判断请求中是否包含
//        String realUrl = request.getContextPath();
//        StringBuffer str = request.getRequestURL();
//        String realUrl = str.toString();
//        System.out.println(realUrl);
//        for(String url:list){
//            if(realUrl.contains(url)){
//                return true;
//            }
//        }

        //3.判断用户是否登录
//        HttpSession session = request.getSession();
//        if(session.getAttribute("userInfo") != null){
//            return true;
//        }

        //4,页面跳转
//        request.getRequestDispatcher("/templates/login.html").forward(request,response);
//        return true;
//        return false;

        HttpSession session = request.getSession();
        if(session.getAttribute("userInfo")==null){
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
