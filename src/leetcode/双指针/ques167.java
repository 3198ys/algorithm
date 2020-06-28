package leetcode.双指针;

import java.util.HashMap;

/**
 * @Author ys 2020/6/28
 * @description 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素
 *
 * 典型的双指针
 */
public class ques167 {
  public int[] twoSum(int[] numbers, int target) {

    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<numbers.length;i++){
      int tmq=target-numbers[i];
      if(map.containsKey(tmq)){
        if (i < map.get(tmq)) {
          return new int[]{i+1,map.get(tmq)+1};
        }else{
          return new int[]{map.get(tmq)+1,i+1};
        }

      }else{
        map.put(numbers[i],i);
      }
    }
    return new int[2];
  }
  public int[] twoSumV2(int[] numbers, int target) {
    int left=0;
    int right=numbers.length-1;
    while (left<right){
      int tmq=numbers[left]+numbers[right];
      if(tmq==target){
        return new int[]{left+1,right+1};
      }else if(tmq<target){
        left++;
      }else{
        right--;
      }
    }
    return new int[2];
  }
}
