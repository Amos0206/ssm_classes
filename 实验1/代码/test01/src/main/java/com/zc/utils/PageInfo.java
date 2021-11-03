package com.zc.utils;

import com.zc.domain.User;
import lombok.*;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/2 20:23
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PageInfo<T>{
    //总记录数
    private Integer count;

    //总页数
    private Integer pageCount;

    //每页的数据
    private List<T> list;
}
