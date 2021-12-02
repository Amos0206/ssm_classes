package com.zc.test;

import com.zc.service.IItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:07
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mvc.xml")
public class ProductServiceTest {
    @Autowired
    private IItemService iItemService;

    @Test
    public void queryAll(){
        System.out.println(iItemService.queryAll());
    }

    @Test
    public void del(){
        System.out.println(iItemService.deleteItem(12));
    }

    @Test
    public void batchDel(){
        String str = "7,10";
        System.out.println(iItemService.batchDelById(str));
    }

    @Test
    public void selectMany(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","面包");
        map.put("price",17);
        System.out.println(iItemService.queryManyCond(map).getData());
    }
}
