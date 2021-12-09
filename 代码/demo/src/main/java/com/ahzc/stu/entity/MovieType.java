package com.ahzc.stu.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 15:43
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MovieType implements Serializable {

    private Integer id;
    
    private String type;
}