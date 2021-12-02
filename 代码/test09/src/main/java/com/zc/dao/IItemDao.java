package com.zc.dao;

import com.zc.entity.Item;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:03
 * @desc
 */
public interface IItemDao {
    List<Item> selectAllProduct();

    Integer delItem(Integer id);


    Integer batchDelById(List<Integer> pids);

    Item queryById(Integer id);

    Integer updateItem(Item item);

    List<Item> selectByMany(Map<String, Object> map);
}
