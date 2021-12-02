package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/2 11:51
 * @desc
 */
@Controller
public class UploadController {
    @RequestMapping("toUpload")
    public String toUp(){
        return "uploadImg";
    }

    /**
     * 图片上传获取图片路径，ajax回显图片的url
     * @param picFile
     * @param request
     * @return
     */
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    @ResponseBody()
    public String toUpload(MultipartFile picFile, HttpServletRequest request){

        //判断picFile是否为空
        if(picFile!=null){
            //获取路径tomcat的
            String path  = request.getServletContext().getRealPath("/");
            //确定上传路径
            File file = new File(path+"/upload");
            if (!file.exists()){
                file.mkdir();
            }
            //重新命名图片
            //获取文件名称
            String orignalStr = picFile.getOriginalFilename();
            //获取文件的.后缀名
            String suffixStr = orignalStr.substring(orignalStr.lastIndexOf('.'));
            System.out.println(suffixStr);
            String newName = UUID.randomUUID().toString();

            //将文件复制到新文件夹下
            File newFile = new File(file.getPath() + "/" + newName + suffixStr);
            try {
                picFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //其他:将上传到tomcat的图片转换到本地
//            String realPath  = path+"/upload/"+newName+suffixStr;//上传到tomcat的路径
//            System.out.println(realPath);
//            String newPath = request.getContextPath()+"/upload/"+newName+suffixStr;//本地路径
//            System.out.println(newPath);
//            FileCopy.copy(realPath,newPath);

            //其他
            String jsonStr = "{\"picUrl\":\""+"/upload/"+ newName+suffixStr+"\"}";
            System.out.println(jsonStr);
            return jsonStr;
        }
        return  "null";
    }
}
