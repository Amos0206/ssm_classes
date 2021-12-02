package com.zc.controller;

import com.zc.entity.Item;
import com.zc.r.ResultBean;
import com.zc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 12:23
 * @desc
 */
@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private IItemService iItemService;


    @RequestMapping("index")
    public String queryAll(Model model){
        ResultBean resultBean = iItemService.queryAll();
        model.addAttribute("productList",resultBean.getData());
        return "product";
    }

    /**
     * 删除数据
     * @param id 商品id
     * @return json格式
     */
    @GetMapping("del/{id}")
    @ResponseBody()
    public ResultBean delById(@PathVariable("id") Integer id){
        return iItemService.deleteItem(id);
    }

    @GetMapping("batch_del")
    @ResponseBody()
    public ResultBean batchDelById(String pids){
        return iItemService.batchDelById(pids);
    }

    @GetMapping("query")
    @ResponseBody()
    public ResultBean queryById(Integer id){
        return iItemService.queryById(id);
    }

    @GetMapping("update")
    @ResponseBody()
    public ResultBean update(Item item){
        return iItemService.updateItem(item);
    }

    @PostMapping("queryByMany")
    @ResponseBody()
    public ResultBean queryByMany(@RequestParam Map<String,Object> map){
//        System.out.println(map);
        return iItemService.queryManyCond(map);
    }
}
