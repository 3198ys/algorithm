package concurrent;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/3/18
 */
public class PriorityQueueDemo {


  public static void main(String[] args) {
    PriorityQueue<Integer> a=new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    a.add(1);
    a.add(3);
    a.add(100);
    a.add(6);
    for(int i=0;i<3;i++){
      System.out.println(a.poll());
    }
  }


}
