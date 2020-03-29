package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/7
 */
public class Counter {

  private AtomicInteger atomicI=new AtomicInteger(0);
  private int i=0;
  public static void main(String[] args) throws InterruptedException {

    Counter counter = new Counter();


    List<Thread> list=new ArrayList<>();
    for(int i=0;i<100;i++){
      Thread thread = new Thread(() -> {
        for (int j = 0; j < 1000; j++) {
          counter.count();
          counter.safeCount();
        }
      });
      list.add(thread);
    }
    for(Thread t:list){
      t.start();
    }
    for(Thread t:list){
      t.join();
    }

    System.out.println(counter.i);
    System.out.println(counter.atomicI);

  }

  private void safeCount(){
    for(;;){
      int i=atomicI.get();
      boolean b = atomicI.compareAndSet(i, ++i);
      if(b){
        break;
      }
    }
  }
  private void count(){
    i++;
  }
}
