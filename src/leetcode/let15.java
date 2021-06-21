package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ys 2021/6/18
 * @description
 */
public class let15 {
  public static List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> resultList=new ArrayList<>();
    Arrays.sort(nums);
    for(int i=0;i<nums.length-2;i++){
      int left=i+1;
      int right=nums.length-1;
      //这一步的去重一定要明白 是当前的i值去和以前的比较 不是现在 num[i]==nums[i+1]这样是会丢值的 一定要记住
      //当前的值和以前的值进行对比 如果以前出现过就跳过
      if(i>0 && nums[i] == nums[i-1]){
       continue;
      }
      while (left<right){
        int total = nums[i] + nums[left] + nums[right];
        if(total ==0){
          //每次有符合条件的穿件一个临时的list
          List<Integer> tmq=new ArrayList<>();
          tmq.add(nums[i]);
          tmq.add(nums[left]);
          tmq.add(nums[right]);
          resultList.add(tmq);
          //别忘了这个数组是有重复的值的所以 需要跳过一些值
          while (left<right && nums[left]==nums[left+1]){
            left++;
          }
          while (left<right && nums[right]==nums[right-1]){
            right--;
          }
          left++;
          right--;
        }else if(total<0){
          left++;
        }else{
          right--;
        }
      }
    }
    return resultList;
  }

  public static void main(String[] args) {
    int [] num=new int[]{-4,-1,-1,0,1,2};
    List<List<Integer>> lists = threeSum(num);
    for(List<Integer> l1:lists){
      for(Integer a:l1){
        System.out.println(a);
      }
      System.out.println("=========");
    }
  }
}
