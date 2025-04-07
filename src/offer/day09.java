package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 * @date:2020/1/19
 */
public class day09 {
  public int JumpFloor(int target) {

    if(target==1){
      return 1;
    }
    if(target==2){
      return 2;
    }
    return JumpFloor(target-1)+JumpFloor(target-2);
  }

  //动态规划来做
  public int JumpFloorV2(int target) {
    if(target==1){
      return 1;
    }
    if(target==2){
      return 2;
    }
    int first=1;
    int second=2;
    int result=0;
    for(int i=3;i<=target;i++){
      result=first+second;
      first=second;
      second=result;
    }
    return result;

  }

  /**
   * 用动态规划来做，动态规划适用的 就是子路径最优解或者不同的结果都有相同的子问题 这些问题都适用动态规划， 动态规划 主要有三点要注意 1 数组的中的每一个值的状态，2 转移的动态方程 也就是 公式 3 边界值
   * 这道题就是动态规划来做  数组中的每一个状态代表当前步骤的，动态转移方程 dp[i] = dp[i-1]+dp[i-2] 边界值就是dp[1] = 1 dp [2] =2
   * @param target
   * @return
   */
  public int dongtaiguihua(int target){

    int [] dp=new int[target+1];
    dp[1] =1;
    dp[2] =2;
    for(int i =3;i<target+1;i++){
      dp[i]=dp[i-1]+dp[i-2];
    }
    return dp[target];
  }
}
