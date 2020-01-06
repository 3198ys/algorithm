package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: leetcode
 * @date:2020-01-03
 */
public class day01 {
//  public int[] twoSum(int[] nums, int target) {
//
//    for(int i=0;i<nums.length;i++){
//      for(int j=0;j<nums.length;j++){
//        if((nums[i]+nums[j]==target) && i!=j){
//          return new int[]{i,j};
//        }
//      }
//    }
//    return new int[0];
//  }

  public int[] twoSum(int[] nums, int target){
    Map<Integer,Integer> resultMap=new HashMap<>();
    for(int i=0;i<nums.length;i++){
      int value=target-nums[i];
      if(resultMap.containsKey(value)){
        return new int[]{i,resultMap.get(value)};
      }
      resultMap.put(nums[i],i);
    }
    return new int[0];
  }

}
