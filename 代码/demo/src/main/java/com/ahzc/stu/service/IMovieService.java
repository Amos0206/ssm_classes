package com.ahzc.stu.service;

import com.ahzc.stu.entity.Movie;
import com.ahzc.stu.vo.ResultBean;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 21:19
 * @desc
 */
public interface IMovieService {
    List<Movie> queryAll(Movie movie);

    ResultBean del(Integer id);

    ResultBean add(Movie movie);

    ResultBean delmany(String ids);

    Movie queryById(Integer id);

    ResultBean edit(Movie movie);
}
