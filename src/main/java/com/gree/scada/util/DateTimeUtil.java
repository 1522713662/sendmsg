package com.gree.scada.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: WeChat
 * @CladdName TimeUtil.java
 * @description: 时间格式工具
 * @author: 260340
 * @create: 2020-04-14 08:59
 **/
public class DateTimeUtil {


    /**
     * 返回 x分钟前的新日期
     * @param date
     * @param mttf 间隔时间
     * @return
     */
    public static String addDateMinut(Date date, int mttf){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 24小时制
        if (date == null)
            return "";
        System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, -mttf);// 24小时制
        date = cal.getTime();
        System.out.println("after:" + format.format(date));  //显示更新后的日期
        return format.format(date);
    }
}
