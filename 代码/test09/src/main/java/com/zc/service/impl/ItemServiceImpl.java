package com.zc.service.impl;

import com.zc.dao.IItemDao;
import com.zc.entity.Item;
import com.zc.r.ResultBean;
import com.zc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 12:21
 * @desc
 */
@Service
public class ItemServiceImpl implements IItemService {
    @Autowired
    private IItemDao iItemDao;

    @Override
    public ResultBean queryAll() {
        List<Item> items = iItemDao.selectAllProduct();
        if(items.size()>0){
            return ResultBean.success("success",items);
        }
        return ResultBean.error("error");
    }

    @Override
    public ResultBean deleteItem(Integer id) {
        Integer i = iItemDao.delItem(id);
        if(i>0){
            return ResultBean.success("success");
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean batchDelById(String pids) {
        String[] split = pids.split(",");
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<split.length;i++){
            list.add(Integer.parseInt(split[i]));
        }
        Integer res = iItemDao.batchDelById(list);
        if(res>0){
            return ResultBean.success("success");
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean queryById(Integer id) {
        Item item = iItemDao.queryById(id);
        if(item!=null){
            return  ResultBean.success("success",item);
        }
        return ResultBean.error("failed");
    }
}
