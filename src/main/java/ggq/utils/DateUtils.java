package ggq.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class DateUtils {

    final static public String fullTimeFormat = "yyyy-MM-dd HH:mm:ss";
    final static public String onlyDateFormat = "yyyy-MM-dd";
    final static public String onlyTimeFormat = "HH:mm:ss";
    final static public String onlyHourFormat = "HH";


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
}
