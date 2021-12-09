package com.ahzc.stu.service.impl;

import com.ahzc.stu.entity.Movie;
import com.ahzc.stu.mapper.IMovieMapper;
import com.ahzc.stu.service.IMovieService;
import com.ahzc.stu.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 21:21
 * @desc
 */
@Service
public class MovieServiceImpl implements IMovieService {
    @Autowired
    private IMovieMapper iMovieMapper;

    @Override
    public List<Movie> queryAll(Movie movie) {
        List<Movie> movies = iMovieMapper.queryAll(movie);
        if (movies.size() > 0) {
            return movies;
        } else {
            return null;
        }
    }

    @Override
    public ResultBean del(Integer id) {
        int i = iMovieMapper.deleteById(id);
        if (i > 0) {
            return ResultBean.success("success", null);
        } else {
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean add(Movie movie) {
        int i = iMovieMapper.insert(movie);
        if (i > 0) {
            return ResultBean.success("success", null);
        } else {
            return ResultBean.error("failed");
        }
    }

    /**
     * 批量删除
     *
     * @param ids 选择的数据id
     * @return resultBean
     */
    @Override
    public ResultBean delmany(String ids) {
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            return iMovieMapper.delManyByIds(list) > 0 ? ResultBean.success("success", null) : ResultBean.error();
        } else {
            return ResultBean.error();
        }
    }

    @Override
    public Movie queryById(Integer id) {
        Movie movie = iMovieMapper.queryById(id);
        if (movie != null) {
            return movie;
        } else {
            return null;
        }
    }

    @Override
    public ResultBean edit(Movie movie) {
        int update = iMovieMapper.update(movie);
        if (update > 0) {
            return ResultBean.success("success", null);
        } else {
            return ResultBean.error("failed");
        }
    }
}
