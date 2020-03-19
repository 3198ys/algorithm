package offer;

import java.util.HashMap;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:统计一个数字在排序数组中出现的次数。
 * @date:2020/3/19
 */
public class day33 {
  public int GetNumberOfK(int [] array , int k) {

    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<array.length;i++){
      if(!map.containsKey(array[i])){
        map.put(array[i],1);
      }else{
        Integer integer = map.get(array[i]);
        map.put(array[i],++integer);
      }
    }
   if(map.containsKey(k)){
     return map.get(k);
   }else{
     return 0;
   }

  }
}
