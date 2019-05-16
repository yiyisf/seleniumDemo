package com.liuzhe.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuzhe on 2019/5/16.
 */
public class DateUtils {
    public static String getTime(){
        Date now = new Date();
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss:SSS");
        return format.format(now);
    }
}
