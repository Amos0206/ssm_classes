package com.zc.domain.vo;

import com.zc.domain.Item;
import com.zc.domain.Itemcategory;
import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/3 8:42
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemVo{
    private int id;
    private String name;
    private Double price;
    private String detail;
    private String pic;
    private int cid;
    private String CREATED_BY;
    private Date CREATED_TIME;
    private String UPDATED_BY;
    private Date UPDATED_TIME;
    private String cateName;
}
