package com.zc.service.impl;

import com.zc.R.ResultBean;
import com.zc.dao.UserDao;
import com.zc.dao.impl.UserDaoImpl;
import com.zc.domain.User;
import com.zc.service.UserService;
import com.zc.utils.PageInfo;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/2 10:05
 * @desc
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public ResultBean allUser() {
        List<User> users = userDao.queryAll();
        if(users.size()>0){
            return ResultBean.success("success",users);
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean queryById(Integer id) {
        User user = userDao.queryById(id);
        if(user!=null){
           return ResultBean.success("success",user);
        }else {
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean save(User user) {
        int i = userDao.insertData(user);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean updated(User user) {
        int i = userDao.updateData(user);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean del(Integer id) {
        int i = userDao.delUser(id);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error("failed");
        }
    }

    /**
     * 返回分页数据
     * @param pageNum
     * @param endindex
     * @return
     */
    @Override
    public PageInfo<User> getPageDates(int pageNum, int endindex) {
        PageInfo<User> page=new PageInfo<>();
        //总记录数
        int count = userDao.queryAll().size();

        //计算总页数
        Integer pageCount = count%endindex==0?count/endindex:count/endindex+1;

        //计算当前页数据
        Integer start  = (pageNum-1)*endindex;

        page.setCount(count);
        page.setPageCount(pageCount);
        page.setList(userDao.getPageDates(start, endindex));
        return page;
    }
}
