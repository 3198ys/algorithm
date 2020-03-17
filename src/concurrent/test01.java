package concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/27
 */
public class test01 {

  public static void main(String[] args) {
    String user="18712782695";
    String s1 = user.replaceAll("(\\d{4})\\d{3}(\\d{4})", "$1****$2");
    System.out.printf(s1);

    String date="2019-01-22 07:00:00";
    String[] s = date.split(" ");
    StringBuffer sb=new StringBuffer();
    String[] split = s[0].split("-");
    String[] split1 = s[1].split(":");
    sb.append(split[0]).append("年").append(split[1]).append("月").append(split[2]).append("日").append(" ").append(split1[0]).append(":").append(split1[1]);
    System.out.println(System.getProperty("java.class.path"));
    System.out.println(sb.toString());
  }

}
