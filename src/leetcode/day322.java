package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *典型的动态规划来做   动态规划就是从下向上去找答案 从最小的 答案开始    比如  f(n) 就是 当前是 n元的时候需要最少多少张硬币  以等于  15 位列
 * 第一张一元  f(15)=f(14)+1
 *      5yuan  f(15)=f(10)+1
 *      10yuan f(15)=f(5)+1
 *
 *      所以就要找到  f(14) f（10）f(5) 最小的  所以就需要找到  小于 15f(n)最小的 之后 一点一点网上家  所以 f(n) =MIn(f(n-1),f(n-5),f(n-10))+1
 *
 * @date:2020/2/20
 */
public class day322 {
  public int coinChange(int[] coins, int amount) {
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> tmqList=new ArrayList<>();
    huisu(coins,amount, list,tmqList,0);
    if(list.size()==0){
     return -1;
    }else {
      int min=Integer.MAX_VALUE;
      for(List<Integer> a:list){
        if(a.size()<=min){
          min=a.size();
        }
      }
      return min;
    }
  }

  public void huisu(int[] coins, int amount,List<List<Integer>> list,List<Integer> tmqList,int start){
    if(amount == 0){
      list.add(new ArrayList<>(tmqList));
      return;
    }
    if(amount<0){
      return;
    }
    for(int i=start;i<coins.length;i++){
      tmqList.add(coins[i]);
      huisu(coins, amount-coins[i], list, tmqList, i);
      System.out.println("now:"+tmqList.toString()+"i="+i);
      tmqList.remove(tmqList.size()-1);
    }
  }
  ///动态规划来做
  public int coinChangeV2(int[] coins, int amount) {

    int [] f=new int[amount+1];
    f[0]=0;
    for(int i=1;i<=amount;i++){
      int min=Integer.MAX_VALUE;
      for(int j=0;j<coins.length;j++){
        if(i-coins[j]>=0){
          if(f[i-coins[j]] != Integer.MAX_VALUE){
            min=Math.min(min,(f[i-coins[j]]+1));
          }
        }
      }
      f[i]=min;
    }
    return f[amount]==Integer.MAX_VALUE?-1:f[amount];
  }

  public int coinChangeV3(int[] coins, int amount) {

    int [] f = new int[amount + 1];
    f[0] = 0;

    for(int i = 1; i <= amount; i++){

      int cost = Integer.MAX_VALUE;

      for(int j = 0; j < coins.length; j++){
        if(i - coins[j] >= 0){
          if(f[i-coins[j]] != Integer.MAX_VALUE)
            cost = Math.min(cost, f[i - coins[j]] + 1);
        }
      }

      f[i] = cost;
    }

    return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
  }


}
