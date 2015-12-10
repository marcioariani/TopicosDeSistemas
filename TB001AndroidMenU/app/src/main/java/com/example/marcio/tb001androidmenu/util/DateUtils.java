package com.example.marcio.tb001androidmenu.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by marcio on 28/11/2015.
 */
public class DateUtils {

    public static Date getDate(int year, int monthOfYear, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        Date date = calendar.getTime();

        return date;
    }

    public static String dateToString(int year, int monthOfYear, int dayOfMonth){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        Date date = calendar.getTime();
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
        String dt = format.format(date);
        return dt;
    }

    public static String dateToString(Date date){
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
        String dt = format.format(date);
        return dt;
    }


}

