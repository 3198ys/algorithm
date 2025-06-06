package leetcode.二分查找;

/**
 * @Author ys 2021/2/7
 * @description 计算并返回 x 的平方根，其中 x 是非负整数。 二分法来做 最最最最 经典的二分查找
 */
public class ques69 {
  public int mySqrt(int x) {

    int l=0; int r=x; int ans=-1;
    while (l<=r){
      int mid= (l+r)/2;

      //这个地方注意一下 要转化成long类型 否者超出时间限制
      if((long)mid*mid<=x){
        ans=mid;
        l=mid+1;
      }else{
        r=mid-1;
      }
    }
    return ans;

  }

  //就一个数的平方根 这个就是典型的二分查找就行了
  public int mysqrtv2(int x){
    int l =0; int r=x;int anx=-1;
    while(l <= x){
      int mid = (l+r)/2;
      if((long) mid*mid <x){
        l= mid+1;
      }else if((long)mid*mid == x){
        anx = mid;
        return anx;
      }else{
        r=mid-1;
      }
    }
    return anx;
  }
}
