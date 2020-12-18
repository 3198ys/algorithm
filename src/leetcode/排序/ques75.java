package leetcode.排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ys 2020/12/17
 *
 * @description 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *     <p>此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *     1 快拍  2 双指针
 *
 */
public class ques75 {

  public static  void sortColors(int[] nums) {

    sort(nums,0,nums.length-1);
    System.out.println(Arrays.toString(nums));
  }

  public static int partion(int [] nums,int start,int end){
    int target=nums[start];
    int left=start;
    int right=end;
    while (left<right){
      while (left<right && target<=nums[right]){
        right--;
      }
      while (left<right && target>=nums[left]){
        left++;
      }
      if(left<right){
        int tmq=nums[right];
        nums[right]=nums[left];
        nums[left]=tmq;
      }
    }
    nums[start]=nums[left];
    nums[left]=target;
    return left;
  }

  public static void sort(int [] nums,int start,int end){
    if(start>=end){
      return ;
    }
    int partion=partion(nums,start,end);
    sort(nums,start,partion-1);
    sort(nums,partion+1,end);
  }

  public static void main(String[] args) {
    int [] nums=new int[]{2,2,1,0,0,1};
    sortColors(nums);
  }

  /**
   * 双指针
   * @param nums
   */
  public void sortColorsV2(int[] nums) {

    int n=nums.length;
    int p0=0,p1=0;
    for(int i=0;i<n;i++){
      if(nums[i]==1){
        int tmq=nums[i];
        nums[i]=nums[p1];
        nums[p1]=tmq;
        ++p1;
      }else if(nums[i]==0){
        int tmq=nums[i];
        nums[i]=nums[p0];
        nums[p0]=tmq;
        //说明0 后面已经有1 了 前面的对0的交换 会把1 交出去 所以这个地方需要吧一拿回来
        if(p0<p1){

          tmq=nums[i];
          nums[i]=nums[p1];
          nums[p1]=tmq;
        }
        ++p0;
        ++p1;
      }
    }
  }
}
