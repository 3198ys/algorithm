package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *

 * @date:2020/2/27
 */
public class day53 {

  public int maxSubArray(int[] nums) {

    int min=Integer.MIN_VALUE;
    int count=0;
    for(int i=0;i<nums.length;i++){
      //加完之后还是小于0 的话  就相同于
      if(count<0){
        count=nums[i];
      }else{
        count+=nums[i];
      }
      if(count>min){
        min=count;
      }
    }
    return min;
  }
  //动态规划  dp[i] 代表 在数组nums中第i个数组的时候最大的自序和是多少
  public int maxSubArrayV2(int[] nums) {
    int dp[]=new int[nums.length];
    dp[0]=nums[0];
    int max=nums[0];
    for(int i=1;i<nums.length;i++){
      dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
      max=Math.max(dp[i],max);
    }
    return max;
  }
}
