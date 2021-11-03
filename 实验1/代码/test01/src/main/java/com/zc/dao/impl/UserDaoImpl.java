package com.zc.dao.impl;

import com.zc.dao.UserDao;
import com.zc.domain.User;
import com.zc.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 22:24
 * @desc
 */
public class UserDaoImpl implements UserDao {
    static Connection conn = null;
    static PreparedStatement stmt = null;
    static ResultSet rs = null;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<User> queryAll() {

        String sql = "SELECT * FROM user";
        List<User> list = new ArrayList<>();
        try {

            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String usernmae = rs.getString("username");
                String password = rs.getString("password");
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String created_by = rs.getString("CREATED_BY");
                String updated_by = rs.getString("UPDATED_BY");
                Date created_time = rs.getDate("CREATED_TIME");
                Date updated_time = rs.getDate("UPDATED_TIME");
                list.add(new User(id, usernmae, password, birthday, sex, created_by, updated_by, created_time, updated_time));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    /**
     * 很具id查询
     *
     * @param id
     * @return
     */
    @Override
    public User queryById(Integer id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String usernmae = rs.getString("username");
                String password = rs.getString("password");
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String created_by = rs.getString("CREATED_BY");
                String updated_by = rs.getString("UPDATED_BY");
                Date created_time = rs.getDate("CREATED_TIME");
                Date updated_time = rs.getDate("UPDATED_TIME");
                user = new User(id, usernmae, password, birthday, sex, created_by, updated_by, created_time, updated_time);
            }
            JDBCUtils.close(conn, stmt);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 添加数据
     *
     * @param user
     * @return
     */
    @Override
    public int insertData(User user) {
        String sql = "INSERT INTO user(username,password,birthday,sex,created_by,updated_by,created_time,updated_time) VALUE(?,?,?,?,?,?,?,?)";
        int result = 0;
        try {

            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setDate(3, new Date(user.getBirthday().getTime()));
            stmt.setString(4, user.getSex());
            stmt.setString(5, "1");
            stmt.setString(6, "1");
            stmt.setDate(7, new Date(new java.util.Date().getTime()));
            stmt.setDate(8, new Date(new java.util.Date().getTime()));
            result = stmt.executeUpdate();
            JDBCUtils.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Override
    public int updateData(User user) {
        String sql = "UPDATE user set username = ?,password = ?,birthday = ?,sex=?,CREATED_BY=?,UPDATED_BY=?,CREATED_TIME=?,UPDATED_TIME = ? where id = ?";
        int result = 0;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setDate(3, new Date(user.getBirthday().getTime()));
            stmt.setString(4, user.getSex());
            stmt.setString(5, "1");
            stmt.setString(6, "1");
            stmt.setDate(7, new Date(new java.util.Date().getTime()));
            stmt.setDate(8, new Date(new java.util.Date().getTime()));
            stmt.setInt(9,user.getId());
            result = stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int delUser(Integer id) {
        String sql = "DELETE FROM user WHERE id=?";
        int result = 0;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            result = stmt.executeUpdate();
            JDBCUtils.close(conn, stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 分页展示数据
     * @param startindex
     * @param endindex
     * @return
     */
    @Override
    public List<User> getPageDates(int startindex, int endindex) {
        List<User> list =new ArrayList<User>();
        String sql="select * " +
                "from user " +
                "limit ?,? ";
        try {
            conn=JDBCUtils.getConnection();//连接数据库
            stmt=conn.prepareStatement(sql);
            stmt.setInt(1,startindex);
            stmt.setInt(2, endindex);
            rs=stmt.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                String usernmae = rs.getString("username");
                String password = rs.getString("password");
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String created_by = rs.getString("CREATED_BY");
                String updated_by = rs.getString("UPDATED_BY");
                Date created_time = rs.getDate("CREATED_TIME");
                Date updated_time = rs.getDate("UPDATED_TIME");
                list.add(new User(id, usernmae, password, birthday, sex, created_by, updated_by, created_time, updated_time));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
