package com.zc.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.R.ResultBean;
import com.zc.service.ItemcategoryService;
import com.zc.service.UserService;
import com.zc.service.impl.ItemcategoryServiceImpl;
import com.zc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/3 10:21
 * @desc
 */
@WebServlet(name = "cateServlet",  value = "*.cate")
public class CateServlet  extends HttpServlet {
    private ItemcategoryService itemcategoryService = new ItemcategoryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取servletPath： /add.do 或 /query.do 等
        String servletPath = request.getServletPath();
        //去除/和.do ： add 或 query
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0, methodName.length() - 5);

        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        try {
            //利用反射获取methondNmae对应的方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //利用反射调用对应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            //response.sendRedirect("error.jsp");    //给用户提示
        }
    }

    /**
     * 查询所有
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ResultBean resultBean = itemcategoryService.queryAll();
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(resultBean));
        response.getWriter().println(jsonObject);
    }
}
