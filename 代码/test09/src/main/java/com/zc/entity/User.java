package com.zc.entity;

import lombok.*;

import java.io.Serializable;
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
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    private String sex;
    private String CREATED_BY;
    private String UPDATED_BY;
    private Date CREATED_TIME;
    private Date UPDATED_TIME;
}