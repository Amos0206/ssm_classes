package com.zc.entity;

import lombok.*;

import java.io.Serializable;

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
public class Customer implements Serializable {
    private Integer id;
    private String  username;
    private String jobs;
    private String phone;
}
