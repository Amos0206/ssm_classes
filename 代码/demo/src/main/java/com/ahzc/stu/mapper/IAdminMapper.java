package com.ahzc.stu.mapper;

import com.ahzc.stu.entity.Admin;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5
 * @desc
 */
public interface IAdminMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Admin> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tAdmin 实例对象
     * @return 对象列表
     */
    List<Admin> queryAll(Admin tAdmin);

    /**
     * 新增数据
     *
     * @param tAdmin 实例对象
     * @return 影响行数
     */
    int insert(Admin tAdmin);

    /**
     * 修改数据
     *
     * @param tAdmin 实例对象
     * @return 影响行数
     */
    int update(Admin tAdmin);

    /**
     * 通过主键删除数据
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 根据用户名查询数据
     * @param username 用户名
     * @return admin
     */
    Admin queryByUsername(String username);

}