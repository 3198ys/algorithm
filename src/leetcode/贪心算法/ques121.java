package leetcode.贪心算法;

/**
 * @Author ys 2021/1/4
 * @description 121. 买卖股票的最佳时机
 */
public class ques121 {
  public static int maxProfit(int[] prices) {

    int minDay=Integer.MAX_VALUE;
    int max=0;
    for(int a:prices){
      if(a<=minDay){
        minDay=a;
      }

      max=Math.max(max,a-minDay);
    }
    return max;
  }

  public static void main(String[] args) {
    int [] a=new int[]{7,1,5,3,6,4};
    int i = maxProfit(a);
    System.out.println(i);
  }
}
