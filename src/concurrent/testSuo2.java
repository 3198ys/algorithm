package concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/4/22
 */
public class testSuo2 {

  public static void main(String[] args) {
    testsuo t1 = new testsuo();
    Integer.parseInt()
    Thread thread = new Thread(new consumer22(t1));
    Thread thread1 = new Thread(() -> {
      testsuo.say2();
    });
    thread.start();
    thread1.start();
    System.out.println("ebd");
  }
}
