package com.zc.dao;

import com.zc.domain.vo.ItemVo;

import java.util.List;


/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/3 8:56
 * @desc
 */
public interface ItemDao {
    public List<ItemVo> queryBycateName(String name);
}
