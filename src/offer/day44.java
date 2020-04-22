package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: offer
 * @date:2020/4/21
 */
public class day44 {


  public List<Integer> getNum(int[] nums){


    PriorityQueue<Integer> queue=new PriorityQueue<>(10,new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    List<Integer> list=new ArrayList<>();
    Set<Integer> set=new HashSet<>();
    for(int i=0;i<nums.length;i++){
      if(i<10){
        queue.add(nums[i]);
        set.add(nums[i]);
      }else{
        Integer peek = queue.peek();

        if(peek>nums[i]){
          if(!set.contains(nums[i])){
            queue.poll();
            queue.add(nums[i]);
            set.remove(peek);
          }
        }
      }
    }
    Iterator<Integer> iterator = queue.iterator();
    while (iterator.hasNext()){
      list.add(iterator.next());
    }
    return list;
  }
}
