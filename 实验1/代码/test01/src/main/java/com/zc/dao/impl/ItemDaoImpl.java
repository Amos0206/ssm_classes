package com.zc.dao.impl;

import com.zc.dao.ItemDao;
import com.zc.domain.vo.ItemVo;
import com.zc.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/4 9:24
 * @desc
 */
public class ItemDaoImpl implements ItemDao {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    @Override
    public List<ItemVo> queryBycateName(String name) {
        String sql ="select i.id,\n" +
                "i.name,\n" +
                "i.price,\n" +
                "i.detail,\n" +
                "i.pic,\n" +
                "i.cid,\n" +
                "i.CREATED_BY,\n" +
                "i.CREATED_TIME,\n" +
                "i.UPDATED_BY,\n" +
                "i.UPDATED_TIME,\n" +
                "ic.cateName\n" +
                "from Item i\n" +
                "INNER JOIN Itemcategory ic\n" +
                "ON ic.cid = i.cid\n" +
                "where ic.cateName = ? ";
        List<ItemVo> itemVo = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name1 = rs.getString("name");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String pic = rs.getString("pic");
                int cid = rs.getInt("cid");
                String cateName = rs.getString("cateName");
                String created_by = rs.getString("CREATED_BY");
                String updated_by = rs.getString("UPDATED_BY");
                Date created_time = rs.getDate("CREATED_TIME");
                Date updated_time = rs.getDate("UPDATED_TIME");
                itemVo.add(new ItemVo(id,name1,price,detail,pic,cid,created_by,created_time,updated_by,updated_time,cateName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return itemVo;
    }
}
