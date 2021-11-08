package com.zc.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.R.ResultBean;
import com.zc.service.ItemService;
import com.zc.service.UserService;
import com.zc.service.impl.ItemServiceImpl;
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
 * @date 2021/11/3 10:22
 * @desc
 */

@WebServlet(name = "itemServlet",  value = "*.item")
public class ItemServlet  extends HttpServlet {
    private ItemService itemService = new ItemServiceImpl();

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
     * 根据分类名查询该分类下的商品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryByName(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String name = request.getParameter("name");
        ResultBean resultBean = itemService.queryByCname(name);
//        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(resultBean));
//        response.getWriter().println(jsonObject);
        request.setAttribute("items",resultBean.getData());
        request.getRequestDispatcher("/page/itemList.jsp").forward(request,response);
    }

}
