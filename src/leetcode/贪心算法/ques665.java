package leetcode.贪心算法;

/**
 * @Author ys 2021/1/13
 * @description 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 */
public class ques665 {

  public static boolean checkPossibility(int[] nums) {

    //nums[i-1] 拐点   nums[i-2] 拐点前的一点  nums[i] 拐点后的一点
    int sum=0;
   for(int i=1;i<nums.length;i++){
     if(nums[i-1]>nums[i]){
       sum++;
       if(sum>=2) return false;
       if(i-2>=0 && nums[i-2]>nums[i]){
         nums[i]=nums[i-1];
       }else{
         nums[i-1]=nums[i];
       }
     }

   }
   return true;
  }

  public static void main(String[] args) {
    int a[]=new int[]{3,4,2,3};
    boolean b = checkPossibility(a);
    System.out.println(b);
  }
}
