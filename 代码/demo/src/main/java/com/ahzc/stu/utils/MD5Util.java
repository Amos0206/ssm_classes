package com.ahzc.stu.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 16:10
 * @desc md5加密
 */
public class MD5Util {
    public static String md5(String password){
        //生成一个md5加密器
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算MD5 的值
            md.update(password.getBytes());
            //BigInteger 将8位的字符串 转成16位的字符串 得到的字符串形式是哈希码值
            //BigInteger(参数1,参数2) 参数1 是 1为正数 0为0 -1为负数
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

