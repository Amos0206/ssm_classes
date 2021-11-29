package com.zc.test;

import com.zc.entity.dto.OrderAndProduct;
import com.zc.entity.dto.OrderAndUser;
import com.zc.entity.dto.UserAndOrder;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 19:08
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

    /**
     * 查询所有订单信息，要求显示输出订单及订单关联的用户信息。
     */
    @Test
    public void orderAndUser(){
        List<OrderAndUser>  ou = sqlSession.selectList("quaryAll");
        for (OrderAndUser e :ou){
            System.out.println(e);
        }
//        System.out.println(ou);
    }

    /**
     * 查询所有用户信息及用户关联的订单信息。
     */
    @Test
    public void userAndOrder(){
        List<UserAndOrder> uo = sqlSession.selectList("queryAllUser");
//        System.out.println(uo);
        for (UserAndOrder e : uo){
            System.out.println(e);
        }
    }

    /**
     * 查询订单明细信息。
     */
    @Test
    public void orderDesc(){
        List<OrderAndProduct> op = sqlSession.selectList("queryOrderDetail");
//        System.out.println(op);
        for (OrderAndProduct e :op){
            System.out.println(e);
        }
    }

    @After
    public void closeSql(){
        sqlSession.close();
    }
}
