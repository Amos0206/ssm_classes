package com.zc.test;

import com.zc.entity.Order;
import com.zc.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/14 14:01
 * @desc
 */
public class DaoTest {
    private SqlSession sqlSession;

    @Before
    public void loadXml(){
        InputStream is = new DaoTest().getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = factory.openSession();
    }

    /*1、添加用户*/
    @Test
    public void inserUser(){
        User user = new User();
        user.setUsername("胡同");
        user.setBirthday(new Date());
        user.setAddress("北京");
        user.setSex("男");
        int insert = sqlSession.insert("insertUser", user);
        sqlSession.commit();
        System.out.println(insert);
    }

    /*2、修改用户*/
    @Test
    public void updateUser(){
        User user  = new User();
        user.setId(1);
        user.setUsername("测试");
        int updateUser = sqlSession.update("updateUser", user);
        sqlSession.commit();
        System.out.println(updateUser);
    }

    /*3、根据id查询用户*/
    @Test
    public void queryById(){
        User user = sqlSession.selectOne("queryById",5);
        System.out.println(user);
    }

    /*
    4、根据用户名称模糊查询用户
     */

    @Test
    public void queryUserByName(){
        List<User> users = sqlSession.selectList("queryUserByName", "张三");
//        System.out.println(users);
        for (User e : users){
            System.out.println(e);
        }
    }

    /**
     * 5、查询用户数据条数
     */
    @Test
    public void count(){
        Integer count = sqlSession.selectOne("count");
        System.out.println(count);
    }


    /**
     * 6、查询所有的订单数据
     */
    @Test
    public void queryOrderList(){
        List<Order> orders = sqlSession.selectList("queryAll");
        System.out.println(orders);
    }

    /*7、根据性别和名字查询用户*/
    @Test
    public  void queryBySexAndName(){
        User user = new User();
        user.setUsername("王五");
        user.setSex("男");
        User u= sqlSession.selectOne("queryBySexAndName", user);
        System.out.println(u);
    }

    /*8、根据多个id查询用户信息*/
    @Test
    public void queryByManyId(){
        List list = new ArrayList();
        list.add(1);
        list.add(4);
        list.add(6);
        List<User> user = sqlSession.selectList("queryByManyId", list);
        System.out.println(user);
    }



    @After
    public void closeSql(){
        sqlSession.close();
    }

}
