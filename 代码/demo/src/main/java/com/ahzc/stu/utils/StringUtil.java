package com.ahzc.stu.utils;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/11 10:56
 * @desc 字符串操作相关
 */
public class StringUtil {

    /**
     * 获取后缀名（不带.）
     * @param fileName
     * @return
     */
    public static String getExtName(String fileName){
        int las = fileName.lastIndexOf(".");
        return fileName.substring(las+1);
    }

    /**
     * 获取文件后缀名（带.）
     * @param fileName
     * @return
     */
    public static String getExtNameWithPoit(String fileName){
        int las = fileName.lastIndexOf(".");
        return fileName.substring(las);
    }

}
