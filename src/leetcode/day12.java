package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *典型的动态规划使用动态规划来做    动态规划  的典型思想 就是由下至上来做
 *
 * 解题思路就是  首先构建一个二维数组  dp[i][j] 代表了  到达i  j这个格子的时候 有多少条路径  在做 动态规划的时候就要有初始化 这里的初始化就是要初始化这个二维数组
 *  这里 在表格的边界也就是  i=0或者  j=0的时候   只会有一种路径可以到到 所以  dp[i][0] 或者  dp[0][j]=1
 *
 *  然后 动态规划的方程  就是  dp[i][j]=dp[i-1][j]+dp[i][j-1] 也就是  到达i j这个节点的时候  他可以从  i-1,j 或者 i,j-1这两哥节点过来 也就是这个两个节点的路径相加就是 这个节点全部的 路径数量了 和跳台阶差不多
  * @date:2020/2/11
 */
public class day12 {

  public int uniquePaths(int m, int n) {

    int [][] dp=new int[m][n];
   for(int i=0;i<m;i++){
     dp[i][0]=1;
   }
   for(int j=0;j<n;j++){
     dp[0][j]=1;
   }
    for(int i=1;i<m;i++){
      for(int j=1;j<n;j++){
        dp[i][j]=dp[i-1][j]+dp[i][j-1];
      }
    }
    return dp[m-1][n-1];
  }
}
