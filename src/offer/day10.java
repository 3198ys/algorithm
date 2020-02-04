package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @date:2020/2/3
 */
public class day10 {

  public int RectCover(int target) {

    if(target==0){
      return 0;
    }
    if(target==1){
      return 1;
    }
    if(target==2){
      return 2;
    }
    return RectCover(target-1)+RectCover(target-2);
  }
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 *题解   f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4).........f(0)
 * f(n-1)=f(n-2).......f(0)
 * 二者相减 所以  f(n)=2*f(n-1)
 */
public class day10 {

    public int JumpFloorII(int target) {

        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }

        return 2*JumpFloorII(target-1);

    }
}
