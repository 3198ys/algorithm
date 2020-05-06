package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *题解动态规划 首先就是要判断当前的值是否是'0' 如果是 '0' 就要判断他前面的是否是 '0' 或者是否 大于2 如果他前面的  =0则匹配不出字符 >2也匹配不出
 * 所以 而且 当 i-2<0 他只有一种 选择 所以是1  比如 10 20 如果 i-2>0则  m[i]=m[i-2] 因为他是 0 所以他只能 和前面的组装出字符 所以占用两个
 * 所以和 i-2相同
 * 当 当前的不是0 的时候就要检查 他前面的是否是0 如果他前面的是0 的话 他只能 在后面加上自己 所以m[i]=m[i-1] 比入1105 他只能加上5
 * 如果前面的不是0 的话  则就要判断 这两个值 加起来之后是否 》26  如果小于 26 i-2<0 则会有两种情况 否则就会 m[i]=m[i-1]+m[i-2];
 * 如果》26 则会m[i]=m[i-1]
 *
 * m[i] 代表在第i个字符的时候  有多少种爬发
 * @date:2020/5/4
 */
  public class day91 {

  public static void main(String[] args) {
    String a="12";
//    int i = numDecodings(a);
//    System.out.println(i);
  }
  public  int numDecodings(String s) {

    if(s.charAt(0)=='0'){
      return 0;
    }
    int[] dp=new int[s.toCharArray().length];
    dp[0]=1;
    for(int i=1;i<s.length();i++){
      /**
       * 先判断当前字符是0的时候
       */
      if(s.charAt(i)=='0'){
        if(s.charAt(i-1)=='0'){
          return 0;
        }else if(s.charAt(i-1)>'2'){
          return 0;
        }else{
          dp[i]=i-2<0?1:dp[i-2];//因为当前的值是 0所以他只能和他前面的值匹配成一个值
        }
      }else{
        if(s.charAt(i-1)=='0'){
          dp[i]=dp[i-1];//因为前面的值是 0的话智能和前面的值 组装成一个
        }else{
          if(Integer.parseInt(s.substring(i-1,i+1))<=26){
            dp[i]=i-2<0?2:dp[i-1]+dp[i-2];
          }else{
            dp[i]=dp[i-1];
          }
        }
      }
    }
    return dp[s.length()-1];
  }
}
