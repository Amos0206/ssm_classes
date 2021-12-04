package com.zc.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 14:35
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    private String sex;
    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;
}