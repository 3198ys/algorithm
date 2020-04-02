package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * @date:2020/4/2
 */
public class let7 {

  public static void main(String[] args) {
    int a=321;
    int b = reverse(a);
    System.out.println(b);
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
}
