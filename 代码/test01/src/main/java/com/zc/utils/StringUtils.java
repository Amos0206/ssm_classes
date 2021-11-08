package com.zc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 22:32
 * @desc
 */
public class StringUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 字符串装换为日期
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String str) throws ParseException {
        return sdf.parse(str);
    }

    /**
     * 日期转换为字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date){
        return sdf.format(date);
    }
}
