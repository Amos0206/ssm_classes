package com.ahzc.stu.service;

import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.entity.News;
import com.ahzc.stu.vo.ResultBean;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 22:55
 * @desc
 */
public interface INewsService {
    List<News> queryAll(News news);

    ResultBean delMany(String ids);

    ResultBean del(Integer id);

    News queryById(Integer id);

    ResultBean add(News news);


    ResultBean edit(News news);
}
