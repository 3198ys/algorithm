package leetcode.排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ys 2020/12/15
 * @description 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 结题思路1 使用堆来做 2 使用桶排序
 */
public class ques347 {

  /**
   * 使用堆来做 创建小丁堆
   * @param nums
   * @param k
   * @return
   */
  public static int[] topKFrequent(int[] nums, int k) {

    //key num value 频率
    Map<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++){
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return map.get(o1) - map.get(o2);
      }
    });
    for(int a:map.keySet()){
      if(queue.size()<k){
        queue.add(a);
      }else if(map.get(a)>map.get(queue.peek())){
        queue.remove();
        queue.add(a);
      }
    }
    //最好倒序输出因为这是一个大顶堆
    int []a=new int[queue.size()];
    int length=queue.size();
    for(int i=0;i<length;i++){
      a[i]=queue.remove();
    }
    return a;
  }

  /**
   * 桶排序 就是构建一个以频率为下标的数组 通过这个数组找到出现前k次的单词
   * @param nums
   * @param k
   * @return
   */
  public static int[] topKFrequentV2(int[] nums, int k){
    Map<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++){
      map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }

    List<Integer> [] bukets=new List[nums.length+1];


    for(int a:map.keySet()){
      int index=map.get(a);
      if(bukets[index] == null){
        bukets[index]=new ArrayList<>();
      }

        bukets[index].add(a);

    }
    List<Integer> res=new ArrayList<>();
    for(int i=bukets.length-1;i>=0 && res.size()<k;i--){
      if(bukets[i] == null) continue;
      res.addAll(bukets[i]);
    }
int [] result=new int[res.size()];
    for(int i=0;i<res.size();i++){
      result[i]=res.get(i);
    }
    return result;
  }
  public static void main(String[] args) {
    int []a=new int[]{1,1,1,2,2,3
    };
    int[] ints = topKFrequentV2(a, 2);
    System.out.printf(Arrays.toString(ints));
  }
}
