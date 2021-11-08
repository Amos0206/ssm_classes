package com.zc.dao;

import com.zc.domain.Itemcategory;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/4 8:52
 * @desc
 */
public interface ItemcategoryDao {
    public List<Itemcategory> queryAll();
}
