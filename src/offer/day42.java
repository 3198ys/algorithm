package offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class day42 {

    public int Add(int num1, int num2) {

        /**
         * 求两个数字相加的和 首先就是求出他们两个数相加的个位  之后 求出他的进位  比如 十进制的时候进位 是1  就要 成10 变成 10  这样 进位和个位相加就是最后的结果了
         */
        while (num2 != 0) {
            int tmq = num1 ^ num2;//通过异或 可以求出两个数相加之后的各位的值
            num2 = (num1 & num2) << 1;  //通过 两个数字 与操作 之后左移一位可以求出 两个数相加的进位
            num1 = tmq;
        }
        return num1;
    }
}
 * @author: create by ys
 * @version: v1.0
 * @description: HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 *
 * 动态规划来做
 * @date:2020/4/16
 */
public class day42 {
  public int FindGreatestSumOfSubArray(int[] array) {

    int dp[]=new int[array.length+1];
    dp[0]=array[0];
int max=array[0];
    for(int i=1;i<array.length;i++){
      dp[i]=Math.max(dp[i-1]+array[i],array[i]);

      max=Math.max(max,dp[i]);
    }
    return max;
  }
}
