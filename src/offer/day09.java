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
}
