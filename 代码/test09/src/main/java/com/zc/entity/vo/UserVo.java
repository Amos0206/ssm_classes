package com.zc.entity.vo;

import com.zc.entity.EdUser;
import lombok.*;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/2 11:26
 * @desc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserVo {
    List<EdUser> users;
}
