package jichu;

import java.math.BigInteger;
import java.security.MessageDigest;
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
//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    Date parse = sdf.parse("2020-09-01 11:00:00");
//    Date parse1 = sdf.parse("2020-08-31 13:00:00");
//    int i = differentDaysByMillisecond(parse1, parse);
//    System.out.println(i);
//
//    Date date = dateAddMinutes(parse1, 1390);
//    System.out.println(sdf.format(date));
   String a="urs";
    String tmqId=a.length()>8?a.substring(a.length()-8,a.length()):a;
    System.out.println(getMD5StrIgnoreException(a));
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

  public static String getMD5StrIgnoreException(String str) {
    try {
      return getMD5Str(str);
    } catch (Exception e) {
      System.out.println("aaa");
    }
    return null;
  }

  public static String getMD5Str(String str) throws Exception {
    try {
      // 生成一个MD5加密计算摘要
      MessageDigest md = MessageDigest.getInstance("MD5");
      // 计算md5函数
      md.update(str.getBytes());
      // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
      // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
      return fillMD5(new BigInteger(1, md.digest()).toString(16));
    } catch (Exception e) {
      throw new Exception("MD5加密出现错误，" + e.toString());
    }
  }

  public static String fillMD5(String md5) {
    return md5.length() == 32 ? md5 : fillMD5("0" + md5);
  }
}
