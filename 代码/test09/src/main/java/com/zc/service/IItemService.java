package com.zc.service;

import com.zc.entity.Item;
import com.zc.r.ResultBean;

import java.util.Map;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 12:21
 * @desc
 */
public interface IItemService {
    ResultBean queryAll();

    ResultBean deleteItem(Integer id);

    ResultBean batchDelById(String pids);

    ResultBean queryById(Integer id);

    ResultBean updateItem(Item item);

    ResultBean queryManyCond(Map<String,Object> map);
}
