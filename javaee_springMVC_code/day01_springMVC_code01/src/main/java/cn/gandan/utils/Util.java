package cn.gandan.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util implements Converter<String, Date> {
    @Override
    public Date convert(String source) {

        if(null == source || source.length() == 0){
            throw new RuntimeException("转换日期为空");
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return df.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型错误");
        }
    }
}
