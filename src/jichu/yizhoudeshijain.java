package jichu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONDAY;

public class yizhoudeshijain {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a="2020-05-09 12:03:20";
        Date noe=sdf.parse(a);

        Calendar instance = Calendar.getInstance();
        instance.setTime(noe);

        int dayWeek=instance.get(Calendar.DAY_OF_WEEK);
        System.out.println("当前是周几"+instance.get(Calendar.DAY_OF_WEEK));
        if (1 == dayWeek) {
            instance.add(Calendar.DAY_OF_MONTH, -1);
        }
        instance.setFirstDayOfWeek(MONDAY);
        int firstDayOfWeek = instance.getFirstDayOfWeek();
        int i = instance.get(Calendar.DAY_OF_WEEK);
        instance.add(Calendar.DATE,firstDayOfWeek-i);

        instance.add(Calendar.DATE,10);
        Date time = instance.getTime();
        System.out.println(sdf.format(time));
        System.out.println("当前是周几"+i);
        System.out.println("第一天是周几"+firstDayOfWeek);
    }
    public static Date convertWeekByDate(Date time, int n) {
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给传入日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, n - 1);
        return cal.getTime();
    }
}
