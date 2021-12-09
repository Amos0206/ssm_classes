package com.ahzc.stu.service.impl;

import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.entity.News;
import com.ahzc.stu.mapper.INewsMapper;
import com.ahzc.stu.service.INewsService;
import com.ahzc.stu.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 22:57
 * @desc
 */
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private INewsMapper newsMapper;

    @Override
    public List<News> queryAll(News news) {
        List<News> news1 = newsMapper.queryAll(news);
        if (news1.size() > 0) {
            return news1;
        } else {
            return null;
        }
    }

    @Override
    public ResultBean delMany(String ids) {
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            return newsMapper.delManyByIds(list) > 0 ? ResultBean.success("success", null) : ResultBean.error();
        } else {
            return ResultBean.error();
        }
    }

    @Override
    public ResultBean del(Integer id) {
        int i = newsMapper.deleteById(id);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error();
        }
    }

    @Override
    public News queryById(Integer id) {
        News news = newsMapper.queryById(id);
        if(news!=null){
            return news;
        }else{
            return null;
        }
    }

    @Override
    public ResultBean add(News news) {
        int i = newsMapper.insert(news);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error();
        }
    }

    @Override
    public ResultBean edit(News news) {
        int i = newsMapper.update(news);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error();
        }
    }
}
