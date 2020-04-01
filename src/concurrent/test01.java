package concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Calendar.MONDAY;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/27
 */
public class test01 {
  static final String[] weeks = new String[]{"星期天","星期一","星期二","星期三","星期四","星期五","星期六",};
  public static void main(String[] args) throws ParseException {
//    String user="18712782695";
//    String s1 = user.replaceAll("(\\d{4})\\d{3}(\\d{4})", "$1****$2");
//    System.out.printf(s1);
//
//    ExecutorService executorService = Executors.newFixedThreadPool(1);
//    Executors.newCachedThreadPool();
//    executorService.execute(()->{
//      System.out.println("aa");
//    });
//    String date="2019-01-22 07:00:00";
//    String[] s = date.split(" ");
//    StringBuffer sb=new StringBuffer();
//    String[] split = s[0].split("-");
//    String[] split1 = s[1].split(":");
//    sb.append(split[0]).append("年").append(split[1]).append("月").append(split[2]).append("日").append(" ").append(split1[0]).append(":").append(split1[1]);
//    System.out.println(System.getProperty("java.class.path"));
//    System.out.println(sb.toString());

//    Calendar cale = new GregorianCalendar(2009,0,31);
//    System.out.println(cale.getTime().toLocaleString());
//    System.out.println("FirstDayOfWeek/tMinimalDaysInFirstWeek/tweek");
//    for (int i = 1; i <= 7; i++) {
//      cale.setFirstDayOfWeek(i);//1为星期天,7为星期六
//      for (int j = 1; j <= 7; j++) {
//        cale.setMinimalDaysInFirstWeek(j);
//        System.out.println(weeks[(i-1)]+"/t"+j+"/t"+cale.get(Calendar.WEEK_OF_MONTH));
//      }
//
//    }


    Vector
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


