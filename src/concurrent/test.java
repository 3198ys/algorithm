package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import sun.misc.Unsafe;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/15
 */
public class test {

  public static void main(String[] args) {
    List<Integer> list=new ArrayList<>();
    list.add(1);
    list.add(1);
    list.add(1);
    System.out.println(list.toString());

    Executors.newFixedThreadPool(1);
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
