package com.ahzc.stu.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 15:41
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin implements Serializable {
    /**
    * 编号
    */
    private Integer id;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String password;
}