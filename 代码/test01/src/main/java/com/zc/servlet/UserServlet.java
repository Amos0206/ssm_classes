package com.zc.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zc.R.ResultBean;
import com.zc.domain.User;
import com.zc.service.UserService;
import com.zc.service.impl.UserServiceImpl;
import com.zc.utils.PageInfo;
import com.zc.utils.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/2 10:25
 * @desc
 */
@WebServlet(name = "userServlet",  value = "*.user")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

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
     * 所有用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResultBean resultBean = userService.allUser();
        List<User> list = (List<User>) resultBean.getData();
        System.out.println(list);
        request.setAttribute("userList", list);
        request.getRequestDispatcher("/page/userList.jsp").forward(request, response);
    }


    /**
     * 用户数据分页
     */
    public void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagenum=(String)request.getParameter("pageNum");//获取当前页面大小
        int endindex=0;
        Integer pageNum;
        if(pagenum==null) {//当前页面为空 默认 第一页3条数据
            pageNum=1;
            endindex=3;
        }else {//当前页面不为空
            pageNum=Integer.parseInt(pagenum);
            endindex=3;
            if(pageNum<=0) {
                pageNum=0;
                endindex=3;
            }else{
                pageNum=Integer.parseInt(pagenum);
                endindex=3;
            }
        }
        PageInfo<User> page=userService.getPageDates(pageNum, endindex);  //查找数据
        request.setAttribute("pageInfo", page);  //将页面信息作为参数传递给jsp页面
        request.getRequestDispatcher("/page/showUserByPage.jsp").forward(request, response);
//        response.getWriter().println(JSON.toJSONString(page));

    }

    /**
     * 添加数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = new User();
        String username = request.getParameter("username");
        String pasword = request.getParameter("password");
        String date = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        user.setUsername(username);
        user.setPassword(pasword);
        try {
            user.setBirthday(StringUtils.stringToDate(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setSex(sex);
        ResultBean save = userService.save(user);
        String s = JSON.toJSONString(save);
        JSONObject jsonObject = JSON.parseObject(s);
        PrintWriter out = response.getWriter();
        out.println(jsonObject);
    }

    /**
     * 删除
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        int i = Integer.parseInt(id);
        ResultBean del = userService.del(i);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(del));
        PrintWriter out = response.getWriter();
        out.println(jsonObject);
    }

    /**
     * 根据id查询用户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void listByUid(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String id = request.getParameter("id");
        Integer i = Integer.parseInt(id);
        ResultBean resultBean = userService.queryById(i);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(resultBean));
        PrintWriter out = response.getWriter();
        out.println(jsonObject);
    }

    /**
     * 修改数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void update(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        User user = new User();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String pasword = request.getParameter("password");
        String date = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        user.setId(id);
        user.setUsername(username);
        user.setPassword(pasword);
        try {
            user.setBirthday(StringUtils.stringToDate(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setSex(sex);
        ResultBean updated = userService.updated(user);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(updated));
        response.getWriter().println(jsonObject);
    }
}
