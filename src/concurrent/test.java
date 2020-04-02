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


    for(int i=0;i<3;i++){
      if(i==2){
        break;
      }
      System.out.println("aaa");
    }
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
