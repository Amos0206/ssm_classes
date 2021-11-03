package com.zc.domain;

import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 22:12
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
    private String CREATED_BY;
    private Date CREATED_TIME;
    private String UPDATED_BY;
    private Date UPDATED_TIME;


}
