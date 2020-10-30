package jichu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ys 2020/7/11
 * @description
 */
public class test1 {

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date parse = sdf.parse("2020-09-01 11:00:00");
    Date parse1 = sdf.parse("2020-08-31 13:00:00");
    int i = differentDaysByMillisecond(parse1, parse);
    System.out.println(i);

    Date date = dateAddMinutes(parse1, 1390);
    System.out.println(sdf.format(date));
  }

  public static int differentDaysByMillisecond(Date startTime, Date endTime) {
    int days = (int) (endTime.getTime() - startTime.getTime()) / (1000*60);
    return days;
  }

  public static Date dateAddMinutes(Date date, int addMinutes) {
    Date newDate = null;
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.MINUTE, addMinutes);
      newDate = cal.getTime();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    return newDate;
  }
}
