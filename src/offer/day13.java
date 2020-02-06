package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: o给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 * 这道题使用 快速幂来做   快速幂的经典场景就是   求一个数的多少次幂 最后的值  但是因为值有可能太大 承担不住 所以就会去最后值的最后几位数字
 *
 * 快速幂  就是 减少指数的大小 增大底数的大小来减少乘法的次数 从而提升 效率   当 指数 是5的时候  就可以变成 比如2^5 就可以变成   2*（16^1） 把  5拆成了   1和4   其实 在拆 指数的过程中呢   就是对 指数 除以2  如果 是奇数的话 就 将底数 乘 一次 就相当于 把一拆出来了
 *
 * 之后如果  指数 是偶数 就把 指数除以2   底数 平方   就可以了
 *
 *
 * 当求结果的最后几位数字的时候 就要注意  要使用的规则就是  (a*b)%1000=(a%1000)*(b%1000)%1000
 * @date:2020/2/6
 */
public class day13 {

  public double Power(double base, int exponent) {

    double sum=1.0;
    int cunt=exponent;
    if(exponent<0){
      exponent=-exponent;
    }
    if(exponent==0){
      return 1;
    }
    while (exponent!=0){
      if((exponent&1)==1){
        //此时 这是一个  奇数的 指数 所以需求 分离出一个底数

        sum=sum*base;
      }
      //如果不是  或者 已经分离完之后 分离完 之后就相当于   指数减一了

      base=base*base;
      exponent>>=1;//这时候就可以直接 除以2 了 除以2  就是一个整数 相当于  （-1之后 在÷2）
    }
    if(cunt>0){
      return sum;
    }else{
      return 1/sum;
    }
  }

  /**
   * 求 最后几位数  最后三位 就是  1000取余   以此类推
   * @param base
   * @param exponent
   * @return
   */
  public double PowerV2(double base, int exponent) {

    double sum=1.0;
    int cunt=exponent;
    if(exponent<0){
      exponent=-exponent;
    }
    if(exponent==0){
      return 1;
    }
    while (exponent!=0){
      if((exponent&1)==1){
        //此时 这是一个  奇数的 指数 所以需求 分离出一个底数

        sum=sum*base%1000;
      }
      //如果不是  或者 已经分离完之后 分离完 之后就相当于   指数减一了

      base=base*base%1000;
      exponent>>=1;//这时候就可以直接 除以2 了 除以2  就是一个整数 相当于  （-1之后 在÷2）
    }
    if(cunt>0){
      return sum;
    }else{
      return 1/sum;
    }
  }
}
