package concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/4/22
 */
public class testsuo {

  public void say(){
    synchronized (this){
//      try {
//        TimeUnit.SECONDS.sleep(10);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }

      System.out.println("say dengdai");
    }
  }



  public static synchronized void say2(){
    System.out.println("say2 dengdai");
  }
}
