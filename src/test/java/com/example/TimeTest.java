package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeTest {
    public static void main(String[] args) {
        isInDate(new Date(),"2018-04-01","2018-04-08");
    }

    public static boolean isInDate(Date date, String strDateBegin, String strDateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String strDate = sdf.format(date);
        System.out.println("strDate="+strDate);
        // 截取当前时间年月日 转成整型
        int  tempDate=Integer.parseInt(strDate.split("-")[0]+strDate.split("-")[1]+strDate.split("-")[2]);
        System.out.println("tempDate="+tempDate);
        // 截取开始时间年月日 转成整型
        int  tempDateBegin=Integer.parseInt(strDateBegin.split("-")[0]+strDateBegin.split("-")[1]+strDateBegin.split("-")[2]);
        System.out.println("tempDateBegin="+tempDateBegin);
        // 截取结束时间年月日   转成整型
        int  tempDateEnd=Integer.parseInt(strDateEnd.split("-")[0]+strDateEnd.split("-")[1]+strDateEnd.split("-")[2]);
        System.out.println("tempDateEnd="+tempDateEnd);
        if ((tempDate >= tempDateBegin && tempDate <= tempDateEnd)) {
            return true;
        } else {
            return false;
        }
    }
}
