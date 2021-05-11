package leetcode;

/**
 * @Author ys 2021/5/10
 *
 * @description 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *     <p>如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *     <p>必须 原地 修改，只允许使用额外常数空间。
 *
 *     这道题的想找到 下一个排列的更大的排列 就是比当前排列 大一点点的，思路就是找到最右边的最小的的一个数字 在找到这个最小的数字右边比他大的的第一个数字反正就是找最
 *     靠近右边的数字进行调换 因为越靠近右边的数字越小，调换完之后再将调换的  数据段进行升序排序
 *     就可以啦
 *
 *
 */
public class day31 {

  public void nextPermutation(int[] nums) {

    //首先找到最右边最小的数字
    int i=nums.length-2;

    while (i>=0 && nums[i]>=nums[i+1]){
      i--;
    }
    //现在已经找到了右边最小的数字,开始比那个最小的稍微大一点的 然后调换位置 这样 增加的是最少的
    int j=nums.length-1;
    if(i>=0){
      while (j>=0 && nums[i]>=nums[j]){
        j--;
      }
      swap(nums,i,j);
    }

    //现在双指针互换变成升序排序 为什么双指针互换就可以呢 因为找到i的时候 说明i之后的数字全部都是降序的 i是比他们都小的
    sort(nums,i+1);
  }

  /**
   * 交换
   * @param nums
   * @param i
   * @param j
   */
  public void swap(int[] nums,int i,int j){
   int tmq=nums[i];
   nums[i]=nums[j];
   nums[j]=tmq;
  }

  /**
   * 从
   * @param nums
   * @param start
   */
  public void sort(int[] nums,int start){

    int left=start;int right=nums.length-1;
    while (left<right){
      swap(nums,left,right);
      left++;
      right--;
    }
  }
}
