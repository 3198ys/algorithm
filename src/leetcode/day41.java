package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 这道题的解题思路就是将 数组视为一个hash表  在 下标 为0的位置就应该是 1 1 就应该是2
 * @date:2020/4/22
 */
public class day41 {
  public int firstMissingPositive(int[] nums) {

    int len=nums.length;
    for(int i=0;i<nums.length;i++){
      while (nums[i]>0 && nums[i]<=len&&nums[nums[i]-1]!=nums[i]){
        swap(nums,nums[i]-1,i);
      }
    }

    for(int i=0;i<nums.length;i++){
      if(nums[i]!=i+1){
        return i+1;
      }
    }
    return len+1;
  }

  public void swap(int nums[],int left,int right){
    int tmq=nums[left];
    nums[left]=nums[right];
    nums[right]=tmq;
  }
}
