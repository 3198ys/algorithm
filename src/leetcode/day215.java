package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @date:2020/5/7
 */
public class day215 {
  public int findKthLargest(int[] nums, int k) {

    int partion = partion(nums, 0, nums.length - 1);
    while (partion!=k-1){
      if(partion<k-1){
        partion=partion(nums,partion+1,nums.length-1);
      }else{
        partion=partion(nums,0,partion-1);
      }
    }
    return nums[partion];

  }


  public int partion(int[] nums,int start,int end){
    int target=nums[start];
    int left=start;
    int right=end;
    while (left<right){
      while (left<right && nums[right]<=target){
        right--;
      }
      while (left<right && nums[left]>=target){
        left++;
      }
      if(left<right){
        int tmq=nums[left];
        nums[left]=nums[right];
        nums[right]=tmq;
      }
    }
    nums[start]=nums[left];
    nums[left]=target;
    return left;
  }
}
