package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 *  
 *

 */
public class day1013 {

  public static void main(String[] args) {
    int []a=new int[]{3,3,6,5,-2,2,5,1,-9,4};
    boolean b = canThreePartsEqualSumV5(a);
    System.out.println(b);
  }
  public static boolean canThreePartsEqualSum(int[] A) {

    int sum=0;
    for(int i=0;i<A.length;i++){
      sum+=A[i];
    }
    int target=sum/3;
    int targetNum=0;
    int tmq=0;
    for(int j=0;j<A.length;j++){
      tmq+=A[j];
      if(tmq==target){
        targetNum++;
        tmq=0;
      }
        System.out.println(tmq);
    }
    if(targetNum>=3){
      return true;
    }else{
      return false;
    }
  }

  /**
   * 双指针
   * @param A
   * @return
   */
  public static boolean canThreePartsEqualSumV3(int[] A) {
    int sum=0;
    for(int i=0;i<A.length;i++){
      sum+=A[i];
    }
    if(sum%3!=0){
      return false;
    }
    int left=0;
    int right=A.length-1;
    int leftSum=A[left];
    int rightSum=A[right];
    while (left+1<right){
      if(leftSum==sum/3 && rightSum==sum/3){
        return true;
      }
      if(leftSum!=sum/3){
        leftSum+=A[++left];
      }
      if(rightSum!=sum/3){
        rightSum+=A[--right];
      }
    }
    return false;
  }

  public boolean canThreePartsEqualSumV4(int[] A) {
    int sum = 0;
    for(int i : A){
      sum += i;
    }
    if(sum%3 != 0){
      // 总和不是3的倍数，直接返回false
      return false;
    }

    // 使用双指针,从数组两头开始一起找，节约时间
    int left = 0;
    int leftSum = A[left];
    int right = A.length - 1;
    int rightSum = A[right];

    // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
    // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
    while(left + 1 < right){
      if(leftSum == sum/3 && rightSum == sum/3){
        // 左右两边都等于 sum/3 ，中间也一定等于
        return true;
      }
      if(leftSum != sum/3){
        // left = 0赋予了初值，应该先left++，在leftSum += A[left];
        leftSum += A[++left];
      }
      if(rightSum != sum/3){
        // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
        rightSum += A[--right];
      }
    }
    return false;
  }

  public static boolean canThreePartsEqualSumV2(int[] A) {
    int sum = 0;
    for(int i: A){
      sum += i;
    }
    if(sum%3 != 0){
      // 总和不是3的倍数，直接返回false
      return false;
    }
    int s = 0;
    int flag = 0;
    for(int i:A){
      s += i;
      if(s == sum/3){
        flag++;
        s = 0;
      }
    }
    // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
    return flag >= 3;
  }

  /**
   * 错误解法
   * @param A
   * @return
   */
  public static boolean canThreePartsEqualSumV5(int[] A) {

    //3,3,6,5,-2,2,5,1,-9,4
    int sum=0;
    for(int i=0;i<A.length;i++){
      sum+=A[i];
    }
    if(sum%3!=0){
      return false;
    }
    int left=0;
    int right=A.length-1;
    int leftSum=0;
    int rightSum=0;
    while (left+1<right){
      if(leftSum==sum/3 && rightSum==sum/3){
        return true;
      }
      if(leftSum!=sum/3){
        /**
         * 这个地方不能先用后加 这样 如果已经到了 目标值了 但是他会是会 向后移动一位
         */
        leftSum+=A[left];
        left++;
      }
      if(rightSum!=sum/3){
        rightSum+=A[right];
        right--;
      }
    }
    return false;
  }

}
