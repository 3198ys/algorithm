package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @date:2020/1/16
 */
public class day05 {

  /**
   * 三层循环来做
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSumV2(int[] nums) {

    //先进行排序
    Arrays.sort(nums);
    List<List<Integer>> list=new ArrayList<>();
    for(int i=0;i<nums.length;i++){
      if(i>0 && nums[i]==nums[i-1]){
        continue;//这么做的原因就是因为 此时 这个数组已经有顺序了 所以这个判断可以去掉重复的数据 就是加入  1 已经用过了 则 有1 的数组能成为目标数组的 就已经全部找出来，这样 在出现一个1 就只能是重复的了所以在这直接去掉
      }
      for(int j=i+1;j<nums.length;j++){
        if(j>i+1 && nums[j]==nums[j-1]){
          continue;
        }
        for(int k=j+1;k<nums.length;k++){
          if(k>j+1 && nums[k]==nums[k-1]){
            continue;
          }
          if(nums[i]+nums[j]+nums[k]==0){
            List<Integer> list1=new ArrayList<>();
            list1.add(nums[i]);
            list1.add(nums[j]);
            list1.add(nums[k]);
            list.add(list1);
            break;
          }
        }
      }
    }

    return list;
  }

  /**
   * 使用双向指针来做
   * 思想就是 将数组先排序 之后从左和右边同时开始找  右边的数字一定是大的 左边的数字一定是小的
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);
    /**
     * 这个地方为什么要nums.length-2呢  因为 是三个数相加的  最外层循环的 是第一个数字  而left指针对应的  则是第二个  right是第三个  当  i是 nums-3最后一个的shihou
     * left是nums。length-2 right是nums.length-1 这样就不会数组越界了 也不会出现使用相同的数字
     */

    List<List<Integer>> list=new ArrayList<>();
    for(int i=0;i<nums.length-2;i++){
      int left=i+1;
      int right=nums.length-1;
      if(i>0 && nums[i]==nums[i-1]){
        continue;
      }
      while (left<right){
        int sum=nums[left]+nums[right]+nums[i];
        if(sum==0){
          List<Integer> list1=new ArrayList<>();
          list1.add(nums[i]);
          list1.add(nums[left]);
          list1.add(nums[right]);
          list.add(list1);
          while (left<right && nums[right]==nums[right-1]){
            right--;
          }
          while (left<right && nums[left]==nums[left+1]){
            left++;
          }
          //进行到下一组
          right--;
          left++;
        }else if(sum>0){
          //说明  right比较大 将right--就可以le
          right--;
        }else{
          left++;
        }

      }
    }
    return list;
  }
}
