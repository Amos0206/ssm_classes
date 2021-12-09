package com.ahzc.stu.mapper;

import com.ahzc.stu.entity.Movie;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 15:41
 * @desc
 */
public interface IMovieMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Movie queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Movie> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tMovie 实例对象
     * @return 对象列表
     */
    List<Movie> queryAll(Movie tMovie);

    /**
     * 新增数据
     *
     * @param tMovie 实例对象
     * @return 影响行数
     */
    int insert(Movie tMovie);

    /**
     * 修改数据
     *
     * @param tMovie 实例对象
     * @return 影响行数
     */
    int update(Movie tMovie);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    int delManyByIds(List<Integer> ids);

}