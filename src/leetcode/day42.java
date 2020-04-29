package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 双指针来做
 * @date:2020/4/23
 */
public class day42 {
  public int trap(int[] height) {


    int left=0;
    int right=height.length-1;
    int max_l=0;
    int max_right=0;
    int ans=0;
    while (left<=right){
      if(max_l<max_right){
        /**
         * 因为左面的最大值如果小于右边的最大值的时候 就以左边为主 去找储水的地方就行 因为这个时候 左面和右边一定会组成一个 水塘只不过要处理
         * 里面的沟沟赫赫
         */
        if(height[left]<max_l){
          ans+=(max_l-height[left]);
        }else{
          max_l=height[left];
        }
        left++;
      }else{
        if(height[right]<max_right){
          ans+=(max_right-height[right]);
        }else{
          max_right=height[right];
        }
        right--;
      }
    }
    return ans;
  }
}
