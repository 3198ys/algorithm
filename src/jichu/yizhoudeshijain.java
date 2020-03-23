package jichu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONDAY;

public class yizhoudeshijain {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String a="2020-03-15 00:00:00";
        Date noe=sdf.parse(a);

        Calendar instance = Calendar.getInstance();
        instance.setTime(noe);
        instance.add(Calendar.DATE,-1);
        instance.setFirstDayOfWeek(MONDAY);
        int firstDayOfWeek = instance.getFirstDayOfWeek();
        int i = instance.get(Calendar.DAY_OF_WEEK);
        instance.add(Calendar.DATE,firstDayOfWeek-i);
        Date time = instance.getTime();
        System.out.println(sdf.format(time));
        System.out.println("当前是周几"+i);
        System.out.println("第一天是周几"+firstDayOfWeek);
    }
}
