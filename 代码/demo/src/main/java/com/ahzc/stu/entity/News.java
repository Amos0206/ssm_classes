package com.ahzc.stu.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 15:44
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class News implements Serializable {
    /**
    * 编号
    */
    private Integer id;
    /**
    * 标题
    */
    private String title;
    /**
    * 作者
    */
    private String author;
    /**
    * 创建时间
    */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    /**
    * 内容
    */
    private String description;
    /**
    * 新闻链接
    */
    private String newLink;
}