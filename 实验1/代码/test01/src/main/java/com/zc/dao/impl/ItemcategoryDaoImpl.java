package com.zc.dao.impl;

import com.zc.dao.ItemcategoryDao;
import com.zc.domain.Item;
import com.zc.domain.Itemcategory;
import com.zc.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/4 9:01
 * @desc
 */
public class ItemcategoryDaoImpl implements ItemcategoryDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs  = null;

    @Override
    public List<Itemcategory> queryAll() {
        String sql = "select * from Itemcategory";
        List<Itemcategory> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                int cid = rs.getInt("cid");
                String cateName = rs.getString("cateName");
                String created_by = rs.getString("CREATED_BY");
                String updated_by = rs.getString("UPDATED_BY");
                Date created_time = rs.getDate("CREATED_TIME");
                Date updated_time = rs.getDate("UPDATED_TIME");
                list.add(new Itemcategory(cid,cateName,created_by,created_time,updated_by,updated_time));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
