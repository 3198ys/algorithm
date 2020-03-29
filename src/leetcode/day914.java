package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:
给定一副牌，每张牌上都写着一个整数。

此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：

每组都有 X 张牌。
组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。
解题思路 使用的事 求最大公约数来做的  统计出 牌中每种牌的个数 之后 一次求最大公约数  最后 所有的最大公约数》=2则是对的
 * @date:2020/3/29
 */
public class day914 {
  public boolean hasGroupsSizeX(int[] deck) {

    int a[]=new int[10000];
    for(int b:deck){
      a[b]++;
    }

    int g=-1;
    for(int i=0;i<a.length;i++){
      if(a[i]>0){
        if(g==-1){
          g=a[i];
        }else{
          g=zuida(g,a[i]);
        }
      }
    }
    return g>=2?true:false;
  }

  public int zuida(int x,int y){
    return x==0?y:zuida(y%x,x);
  }
}
