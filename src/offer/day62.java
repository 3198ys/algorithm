package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:链接：https://www.nowcoder.com/questionTerminal/57d85990ba5b440ab888fc72b0751bf8
 * 来源：牛客网
 *
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *这道题的解法有两个 一个是 通过 贪心算法 就是 通过 2 3 来分割绳子
 * 2 动态规划来做 动态规划的思想现在就是 将绳子拆分 的话 其实 就是 最后其实可以拆分成两个 绳子长度想乘 dp[i]就是长度是i的时候成绩最大的是时候
 *
 * @date:2020/6/3
 */
public class day62 {

    public int cutRope(int target) {

        if(target==2){
            return 1;
        }else if(target==3){
            return 2;
        }
        if(target%3==0){
            return (int)Math.pow(3,target/3);
        }else if(target%3==1){
            //说明 一顿拆分之后一定有一个4
            return 2*2*(int)Math.pow(3,target/3-1);
        }else{
            return 2*(int)Math.pow(3,target/3);
        }
    }

    /**
     * 动态规划
     * @param target
     * @return
     */
    public int cutRopeV2(int target){
        if(target==2){
            return 1;
        }else if(target==3){
            return 2;
        }
        int[] dp=new int[target+1];
        /**
         * 这个 dp的初始化 就是 找前三个没有分一道的情况  也就是最大的情况
         */
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int res=0;
        for(int i=4;i<=target;i++){
            for(int j=1;j<=i/2;j++){
                res=Math.max(res,dp[j]*dp[i-j]);
            }
            dp[i]=res;
        }
        return dp[target];
    }
}
