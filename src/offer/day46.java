package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: offer
 * @date:2020/4/24
 */
public class day46 {

  boolean limit(long millis)
  {


    PriorityQueue queue=new PriorityQueue(5, new Comparator<Long>() {

      @Override
      public int compare(Long o1, Long o2) {
        return Integer.valueOf(Long.toString(o1-o2));
      }
    });



       if(!queue.isEmpty()){
         Long peek =(Long) queue.peek();
         if(millis-peek<10){
           if(queue.size()<5){
             queue.offer(millis);
             return true;
           }else{
             //超过阈值
             return false;
           }
         }else{
           queue.clear();
         }
       }else{
         queue.offer(millis);
         return true;
       }


     return false;
  }
}
