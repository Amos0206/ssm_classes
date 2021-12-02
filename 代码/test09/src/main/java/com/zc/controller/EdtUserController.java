package com.zc.controller;

import com.zc.entity.EdUser;
import com.zc.entity.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/2 11:37
 * @desc
 */
@Controller()
public class EdtUserController {
    @RequestMapping("toEditUser")
    public String edUserIndex(){
        return "EditUser";
    }

    @PostMapping("editUsers")
    public String editUser(UserVo userList){
        List<EdUser> users = userList.getUsers();
        for (EdUser user : users) {
            if(user.getId() !=null){
                System.out.println("修改了id为"+user.getId()+"的用户名为："+user.getName());
            }
        }
        return "success";
    }
}
