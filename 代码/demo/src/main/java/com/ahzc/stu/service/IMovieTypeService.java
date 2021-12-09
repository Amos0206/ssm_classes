package com.ahzc.stu.service;

import com.ahzc.stu.entity.Movie;
import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.vo.ResultBean;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 21:52
 * @desc
 */
public interface IMovieTypeService {
    List<MovieType> queryAll(MovieType type);

    ResultBean delMany(String ids);

    ResultBean del(Integer id);

    MovieType queryById(Integer id);

    ResultBean add(MovieType type);


    ResultBean edit(MovieType movie);
}
