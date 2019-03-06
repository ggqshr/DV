package ggq.utils;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class DateUtils {

    final static public String fullTimeFormat = "yyyy-MM-dd HH:mm:ss";
    final static public String onlyDateFormat = "yyyy-MM-dd";
    final static public String onlyTimeFormat = "HH:mm:ss";
    final static public String onlyHourFormat = "HH";
    final static public SimpleDateFormat date2Str = new SimpleDateFormat("yyyy-MM-dd");
    final static public SimpleDateFormat str2Date = new SimpleDateFormat("yyyy-MM-dd");


    public String getCurrentDate(String timeFormat){
        if(timeFormat==null){
            timeFormat = onlyDateFormat;
        }
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(timeFormat);
        return df.format(date);
    }

    public String getDateSubResult(int subTimeNumber){
        SimpleDateFormat df = new SimpleDateFormat(onlyDateFormat);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, subTimeNumber);
        return df.format(cal.getTime());
    }

    public int getIntervalDays(String oldDateStr, String newDateStr) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date oldDate = format.parse(oldDateStr);
        Date newDate = format.parse(newDateStr);
        if (oldDate.after(newDate)) {
            throw new IllegalArgumentException("时间先后顺序不对!");
        }
        //将转换的两个时间对象转换成Calendard对象
        Calendar can1 = Calendar.getInstance();
        can1.setTime(oldDate);
        Calendar can2 = Calendar.getInstance();
        can2.setTime(newDate);
        //拿出两个年份
        int year1 = can1.get(Calendar.YEAR);
        int year2 = can2.get(Calendar.YEAR);
        //天数
        int days = 0;
        Calendar can = null;
        //减去小的时间在这一年已经过了的天数
        //加上大的时间已过的天数
        days -= can1.get(Calendar.DAY_OF_YEAR);
        days += can2.get(Calendar.DAY_OF_YEAR);
        can = can1;
        for (int i = 0; i < Math.abs(year2 - year1); i++) {
            //获取小的时间当前年的总天数
            days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
            //再计算下一年。
            can.add(Calendar.YEAR, 1);
        }
        return days;
    }
    public  List<String> findDates(String dBegin, String dEnd) throws ParseException {
        //日期工具类准备
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        //设置开始时间
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(format.parse(dBegin));

        //设置结束时间
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(format.parse(dEnd));

        //装返回的日期集合容器
        List<String> Datelist = new ArrayList<String>();
        Datelist.add(dBegin);
        // 每次循环给calBegin日期加一天，直到calBegin.getTime()时间等于dEnd
        while (format.parse(dEnd).after(calBegin.getTime()))  {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            Datelist.add(format.format(calBegin.getTime()));
        }

        //打印结果 [2018-10-01, 2018-10-02, 2018-10-03, 2018-10-04, 2018-10-05, 2018-10-06, 2018-10-07, 2018-10-08, 2018-10-09, 2018-10-10, 2018-10-11, 2018-10-12, 2018-10-13, 2018-10-14, 2018-10-15, 2018-10-16, 2018-10-17, 2018-10-18, 2018-10-19, 2018-10-20, 2018-10-21, 2018-10-22, 2018-10-23, 2018-10-24, 2018-10-25]
        return Datelist;
    }
}
