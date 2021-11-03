package com.zc.testDao;

import com.zc.dao.impl.UserDaoImpl;
import com.zc.domain.User;
import com.zc.utils.StringUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 22:57
 * @desc
 */
public class DaoTest {

    @Test
    public void queryAllUser(){//查新所有
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.queryAll();
        for (User user :users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryById(){
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.queryById(3);
        System.out.println(user);
    }

    @Test
    public void insertData(){
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("a");
        user.setPassword("123");
        try {
            user.setBirthday(StringUtils.stringToDate("2021-3-5"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setSex("男");
        int i = userDao.insertData(user);
        System.out.println(i);
    }

    @Test
    public void del(){
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.delUser(8);
        System.out.println(i);
    }

    @Test
    public void update() throws ParseException {
        User user = new User();
        user.setId(9);
        user.setUsername("fdsahgsa");
        user.setPassword("32423");
        user.setBirthday(StringUtils.stringToDate("2021-4-23"));
        user.setSex("女");
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.updateData(user);
        System.out.println(i);
    }
}
