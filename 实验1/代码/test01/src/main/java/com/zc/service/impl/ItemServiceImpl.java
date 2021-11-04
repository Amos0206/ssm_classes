package com.zc.service.impl;

import com.zc.R.ResultBean;
import com.zc.dao.ItemDao;
import com.zc.dao.impl.ItemDaoImpl;
import com.zc.domain.vo.ItemVo;
import com.zc.service.ItemService;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/4 9:58
 * @desc
 */
public class ItemServiceImpl implements ItemService {
    private ItemDao dao= new ItemDaoImpl();

    @Override
    public ResultBean queryByCname(String name) {
        List<ItemVo> itemVos = dao.queryBycateName(name);
        if(itemVos.size()>0){
            return ResultBean.success("success",itemVos);
        }else{
            return ResultBean.error("failed");
        }
    }
}
