package com.ahzc.stu.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 15:42
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie implements Serializable {
    /**
    * 编号
    */
    private Integer id;
    /**
    * 电影名
    */
    private String name;
    /**
    * 封面
    */
    private String img;
    /**
    * 导演
    */
    private String director;
    /**
    * 演员
    */
    private String actor;
    /**
    * 电影类别
    */
    private String type;
    /**
    * 电影简介
    */
    private String mDesc;
    /**
    * 电影链接
    */
    private String vLink;
}