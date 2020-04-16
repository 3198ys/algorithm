package concurrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import sun.misc.Unsafe;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/15
 */
public class test {

  public static void main(String[] args) throws ParseException {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String a="2020-04-05 00:00:00";
    Date noe=sdf.parse(a);

    Calendar instance = Calendar.getInstance();
    instance.setTime(noe);
    System.out.println();
    new ThreadPoolExecutor(0,0,60, TimeUnit.MINUTES,new LinkedBlockingDeque<>()){
      @Override
      protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("aaa");
      }
    };
  }


  public static int hell(){
    int a=0;
    try{

      a++;
      return a;
    }catch (Exception e){
      e.printStackTrace();
    }finally {

      ++a;
      return a;
    }

  }
  public void cc(){
    new aa().say();
    new bb().say1();
  }
  private static class aa{
    public void say(){
      System.out.println("aaa");
    }
  }

  private class bb{
    private void say1(){
      System.out.println("aaaaa");
    }
  }
}
