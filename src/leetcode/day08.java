package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @date:2020/1/19
 */
public class day08 {

  public static void main(String[] args) {

    String cc=
        "babad";

    String s = longestPalindrome(cc);
    System.out.println(s);
  }
  public static String longestPalindrome(String s) {

    int max=0;
    String a="";
    for(int i=0;i<s.length();i++){
      StringBuffer sb=new StringBuffer();
      for(int j=i;j<s.length();j++){
        sb.append(s.charAt(j));
        if(getLong(sb)){
          if(sb.length()>=max){
            max=sb.length();
            a=sb.toString();
          }
        }
      }
    }
    return a;
  }

  public static boolean getLong(StringBuffer s){

    StringBuffer tmq=new StringBuffer().append(s);
    if(tmq.reverse().toString().equals(s.toString())){
      return true;
    }else{
      return false;
    }
  }
}
