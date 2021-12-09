package com.ahzc.stu.service.impl;

import com.ahzc.stu.entity.Movie;
import com.ahzc.stu.entity.MovieType;
import com.ahzc.stu.mapper.IMovieTypeMapper;
import com.ahzc.stu.service.IMovieTypeService;
import com.ahzc.stu.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 21:55
 * @desc
 */
@Service
public class MovieTypeServiceImpl implements IMovieTypeService {
    @Autowired
    private IMovieTypeMapper movieTypeMapper;


    @Override
    public List<MovieType> queryAll(MovieType type) {
        List<MovieType> movieTypes = movieTypeMapper.queryAll(type);
        if (movieTypes.size() > 0) {
            return movieTypes;
        } else {
            return null;
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public ResultBean delMany(String ids) {
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        if (split.length > 0) {
            for (int i = 0; i < split.length; i++) {
                list.add(Integer.parseInt(split[i]));
            }
            return movieTypeMapper.delMany(list) > 0 ? ResultBean.success("success", null) : ResultBean.error();
        } else {
            return ResultBean.error();
        }
    }

    @Override
    public ResultBean del(Integer id) {
        int i = movieTypeMapper.deleteById(id);
        if (i > 0) {
            return ResultBean.success("success", null);
        } else {
            return ResultBean.error();
        }
    }

    @Override
    public MovieType queryById(Integer id) {
        MovieType type = movieTypeMapper.queryById(id);
        if (type != null) {
            return type;
        }else{
            return null;
        }
    }

    @Override
    public ResultBean add(MovieType type) {
        int i = movieTypeMapper.insert(type);
        if (i > 0) {
            return ResultBean.success("success", null);
        } else {
            return ResultBean.error();
        }
    }

    @Override
    public ResultBean edit(MovieType movie) {
        int i = movieTypeMapper.update(movie);
        if (i > 0) {
            return ResultBean.success("success", null);
        } else {
            return ResultBean.error();
        }
    }
}
