package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 这道题的结题思路就是 对 原来那个数字 取余数  之后利用余数返现*10加余数一直获取到翻转的 整数  这里主要就是要注意  不要超过Integer.MaxValue 和  Integer.Min_value
 *
 *
 * @date:2020/4/2
 */
public class let7 {

  public static void main(String[] args) {


    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);
  }

  public static int reverse(int x) {

    String s = String.valueOf(x);
    char[] chars;
    if(x<0){
       chars = s.toCharArray();
     chars= fan(chars,1,chars.length-1);
    }else{
       chars = s.toCharArray();
      chars=fan(chars,0,chars.length-1);
    }

    return Integer.valueOf(new String(chars));
  }

  public static char[] fan(char[] a,int start,int end){
    char tmq;
    while (start<end){
      tmq=a[start];
      a[start]=a[end];
      a[end]=tmq;
      start++;
      end--;
    }
    return a;
  }

  public  int goodreverse(int x) {
    int rev=0;
    while (x!=0){
      int pop=x%10;
      x/=10;
      if(rev>Integer.MAX_VALUE/10 || rev==Integer.MAX_VALUE/10 && pop>7) return 0;
      if(rev<Integer.MIN_VALUE/10 || rev==Integer.MIN_VALUE/10 && pop<-8) return 0;
      rev=rev*10+pop;
    }
    return rev;
  }

}
