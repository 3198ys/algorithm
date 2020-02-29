package concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/14
 */
public class MyCountDownLatch {

  private int count;

  public MyCountDownLatch(int count) {
    this.count = count;
  }

//  ReentrantReadWriteLock
  public void countdown() throws InterruptedException{
    if(Thread.interrupted()){
      throw new InterruptedException();
    }
    synchronized (this){
      while (count>0){
        wait();
      }
    }

  }

  public void await(){
    synchronized (this){
      if(count<1){
        return;
      }
      count--;
      if(count == 0){
        notifyAll();
      }
    }
  }
}
