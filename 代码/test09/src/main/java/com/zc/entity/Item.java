package com.zc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:03
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private int id;
    private String name;
    private Double price;
    private String detail;
    private String pic;
    private int cid;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
}
