package leetcode;

/**
 * @Author ys 2021/6/17
 *
 * @description 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和
 *     (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *   这道题就是最典型的双指针的解法  盛水的容量就是 左边或者右边选最矮的 * r-l 就可以了，然后盛水的容量选出最大的 如果左边比右边小 则向右移动 右边的比左边的小向左移动就是谁小移动谁
 */
public class let11 {
  public int maxArea(int[] height) {

    int left=0;
    int right=height.length-1;
    int max=0;
    while (left<=right){
      int ans=Math.min(height[left],height[right])*(right-left);
       max=Math.max(max,ans);
       if(height[left]<=height[right]){
         left++;
       }else{
         right--;
       }
    }
    return max;
  }
}
