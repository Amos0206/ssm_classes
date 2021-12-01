package com.zc.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 21:47
 * @desc
 */
public class MySelfConverter implements Converter<String,Date> {
    /*
     声明一个变量包含匹配的可能元素,
  */
    private List<String> patterns;

    @Override
    public Date convert(String s) {
        if (patterns == null || patterns.isEmpty()) {
            patterns = new ArrayList<>();
            patterns.add("yyyy-MM-dd");
        }
        for (String pattern : patterns) {
            SimpleDateFormat sf = new SimpleDateFormat(pattern);
            Date date = null;
            try {
                date = sf.parse(s);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }
}
