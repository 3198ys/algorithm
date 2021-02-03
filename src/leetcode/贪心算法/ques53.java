package leetcode.贪心算法;

/**
 * @Author ys 2021/2/3
 * @description 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 动态规划来做
 */
public class ques53 {
  public int maxSubArray(int[] nums){
    if(nums.length==0 || nums==null){
      return 0;
    }
    int[] dp=new int[nums.length]; //在第i个元素的时候连续子数组的最大和
    dp[0]=nums[0];
    int max=nums[0];
    for(int i=1;i<nums.length;i++){
      dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
      max=Math.max(dp[i],max);
    }
    return max;
  }
}
