package jichu;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ys 2021/6/25
 * @description
 */
public class test4 {

  public static void main(String[] args) {
    ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
    HashMap<String, String> map2 = new HashMap<>();

    ReentrantLock reentrantLock = new ReentrantLock();
    boolean b = reentrantLock.tryLock();

    String put = map.put("ac", "a");
    String put1 = map.put("ac", "b");
    System.out.println(put1);
  }
}
