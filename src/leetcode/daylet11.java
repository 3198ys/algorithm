package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *  
 * 暴力方法 就是两层循环就可以了
 * 好的方法  双指针来做  这里 首先其实就是求的一个长方形的面积   利用双指针的话 指针首先指向 首尾 所以此时 长方形的长是最长的 而长方形的宽是选择 两个指针中最短的  因为是盛水用的所以用最短的
 * 当算出来一个之后  将最短的一边向里面移动因为 最短的一边是影响整个面子的关键  因为长 已经是从最大开始的  而宽是从最小开始的 所以 将最小的网里面移动
商业转载请联系官方授权，非商业转载请注明出处。
 * @date:2020/2/29
 */
public class daylet11 {
  public int maxArea(int[] height) {

     int max=0;
     for(int i=0;i<height.length;i++){
       for(int j=0;j<i;j++){
         int mianji=0;
         if(height[i]<height[j]){
           mianji=(i-j)*height[i];
         }else{
           mianji=(i-j)*height[j];
         }
         if(mianji>=max){
           max=mianji;
         }
       }
     }
     return max;
  }
  //双指针
  public int maxAreaV3(int[] height) {

   int max=0; int left=0;int right=height.length-1;
   while (left<right){
     max=Math.max(max,Math.min(height[left],height[right])*(right-left));
     if(height[left]<height[right]){
       left++;
     }else{
       right--;
     }
   }
   return max;
  }
  public static int maxAreaV2(int[] height) {

    int max=0;
    for(int i=0;i<height.length;i++){
      for(int j=0;j<i;j++){
        int mianji=0;
        if(height[i]<height[j]){
          mianji=(i-j)*height[i];
        }else{
          mianji=(i-j)*height[j];
        }
        if(mianji>=max){
          max=mianji;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int [] a=new int[]{1,8,6,2,5,4,8,3,7};
    int i = maxAreaV2(a);
    System.out.println(i);
  }
}
