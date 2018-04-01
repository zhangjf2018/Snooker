package com.ymtdata.snooker.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by ai on 2018/4/1.
 */
public class DateUtil {


    public static int getCurrHour(){
        String hour = new SimpleDateFormat("HH").format(new Date());
        return Integer.parseInt(hour);
    }

    public static int getCurrMin(){
        String mm = new SimpleDateFormat("mm").format(new Date());
        return Integer.parseInt(mm);
    }

}
