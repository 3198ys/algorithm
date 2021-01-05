package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ys 2021/1/5
 * @description 122. 买卖股票的最佳时机 II
 */
public class ques122 {
  //使用动态规划来做
  public static int maxProfit(int[] prices) {

    int length=prices.length;
    if(length<2){
      return 0;
    }

    // 0 持有现金
    //1 持有股票 也就是 如果持有股票，当前拥有的现金数是当天股价的相反数，即 dp[0][1] = -prices[i]
    int[][] dp=new int[length][2];

    dp[0][0]=0;
    dp[0][1]=-prices[0];
    for(int i=1;i<prices.length;i++){
      //这里 dp[i-1][1]+prices[i] 相当于吧股票迈出了

      dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
      dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
    }
    return dp[length-1][0];
  }

  public static void main(String[] args) {
    int [] a=new int[]{1,2,3,4,5};
    int i = maxProfit(a);
    System.out.println(i);
  }
}
