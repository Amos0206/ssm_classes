package com.zc.service.impl;

import com.zc.R.ResultBean;
import com.zc.dao.ItemcategoryDao;
import com.zc.dao.impl.ItemcategoryDaoImpl;
import com.zc.domain.Itemcategory;
import com.zc.service.ItemcategoryService;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/4 9:59
 * @desc
 */
public class ItemcategoryServiceImpl implements ItemcategoryService {
    private ItemcategoryDao dao = new ItemcategoryDaoImpl();

    @Override
    public ResultBean queryAll() {
        List<Itemcategory> itemcategories = dao.queryAll();
        if(itemcategories.size()>0){
            return ResultBean.success("success",itemcategories);
        }else{
            return ResultBean.error();
        }
    }
}
