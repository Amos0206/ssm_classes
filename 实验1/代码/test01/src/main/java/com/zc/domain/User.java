package com.zc.domain;

import lombok.*;

import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 22:01
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
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
