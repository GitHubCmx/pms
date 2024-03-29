package com.offcn.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//全局类型转换器
public class DateTimeConverter implements Converter<String, Date> {


    public Date convert(String source) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(source);
            return date;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }


    }
}
