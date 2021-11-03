package com.zc.domain;

import com.alibaba.druid.filter.AutoLoad;
import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 22:08
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Itemcategory {
    private Integer cid;
    private String cateName;
    private String CREATED_BY;
    private Date CREATED_TIME;
    private String UPDATED_BY;
    private Date UPDATED_TIME;
}
