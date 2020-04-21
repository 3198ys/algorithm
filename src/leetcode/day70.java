package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * @date:2020/2/24
 */
public class day70 {
  public int climbStairsV2(int n) {

    if(n==1){
      return 1;
    }
    if(n==2){
      return 2;
    }
    return climbStairs(n-1)+climbStairs(n-2);

  }
  public int climbStairs(int n) {
    if(n==1){
      return 1;
    }
    if(n==2){
      return 2;
    }
     int a=1;
     int b=2;
     int c=0;
     for(int i=3;i<=n;i++){
       c=a+b;
       a=b;
       b=c;
     }
     return c;
  }

}
