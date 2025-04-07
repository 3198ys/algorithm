package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 这道题的 精妙之处在于  一个数 减去1之后 他的 二进制中最右边的 的1 就会变为0   比如1100  减1之后   就是 1011  此时本身与他进行且操作的时候  就会变成了1000 这时候  他的二进制 中的1 就会减掉一个 这样不断循环知道  这个数字变为0
 * @date:2020/2/4
 */
public class day12 {

  public int NumberOf1(int n) {

    int count=0;
    while (n!=0){
      count++;
      n=n&(n-1);
    }
    return count;
  }


  public int number02(int target){
    if(target == 0){
      return 0;
    }
    int count =0;
    while (target != 0){
      count++;
      target = target & (target-1);
    }
    return count;
  }
}
