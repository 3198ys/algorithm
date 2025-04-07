package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @date:2020/1/15
 */
public class day07 {
  public int FibonacciV2(int n) {

    if(n==0){
      return 0;
    }
    if(n==1||n==2){
      return 1;
    }
    return FibonacciV2(n-1)+FibonacciV2(n-2);
  }

  /**
   * 使用动态规划来做  动态规划实际上就是 从低想上分解 并且将 每个低层的运算都存起来了
   * @param n
   * @return
   */
  public int Fibonacci(int n) {


    if(n==0){
      return 0;
    }
    int [] nums=new int[n+1];
    nums[0]=0;
    nums[1]=1;

    for(int i=2;i<=n;i++){
      nums[i]=nums[i-1]+nums[i-2];
    }
    return nums[n];
  }

  //实际上动态规划就是要先找到公式，动态规划一般都是通过底层向上去找，是有一定公式的
  public int FibonacciV3(int n) {
    if(n==0){
      return 0;
    }
    if(n == 1 || n== 2){
      return 1;
    }
    return FibonacciV2(n-1)+FibonacciV2(n-2);
  }

}
