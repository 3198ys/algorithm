package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *这道题使用动态规划来做  q[i]代表了i这个节点他的最长升序子序列长度是多少，如果 nums[i]>nums[j] 则 nums[i]可以直接追加到 nums[j]后面  所以q[i]=Max(q[i],q[j]+1)  这里的 q[i]是1  这里每个单独的字符都认为是一个生序列 所以 长度是1
 */
public class day300 {

  public int lengthOfLIS(int[] nums) {


    int []dp=new int[nums.length+1];
    Arrays.fill(dp,1);
    int max=0;
    for(int i=0;i<nums.length;i++){
      for(int j=0;j<i;j++){
        //这里 j只要小于i就行不需要 等于 因为  j是i的前一位 切  nums[j]<nums[i]的时候才会 在原来的 基础上加1
        if(nums[j]<nums[i]){
          //这里dp【j】就是到j这个节点的时候 最长的升序序列
          dp[i]=Math.max(dp[i],dp[j]+1);
        }
      }
      if(dp[i]>=max){
        max=dp[i];
      }
    }
    return max;
  }



}
