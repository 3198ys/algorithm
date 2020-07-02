package leetcode.双指针;

/**
 * @Author ys 2020/7/2
 * @description给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 使用双指针 就一定要知道 两个指针的 位置  这里左指针就是  等于0  右指针就是 对 targert进行开方
 */
public class ques633 {
  public boolean judgeSquareSum(int c) {

    int left=0;
    int right= (int) Math.sqrt(c);
    while (left<=right){
      int tmq=left*left+right*right;
      if(tmq==c){
        return true;
      }else if(tmq<c){
        left++;
      }else{
        right--;
      }
    }
    return false;
  }
}
