package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: leetcode
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
