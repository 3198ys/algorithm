package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 最长回文   比三层循环更好的方法就是使用 动态规划来做  这里  创建一个二维数组  dp[i][j]代表从i到j的字符串 中是否有回文
 * 之后判断是否有回文就可以根据  dp[i][j]=(s[i]==s[j] && dp[i+1][j-1])如果   这个字符串的首尾是相同  而且生于的事回文的则它也是回文
 *
 * 而 dp[i+1][j-1]是回文的方法就是   j-1-i-1 +1<2 所以  j-i<3
 * 而动态规划一定要有初始化 这里的初始化就是   所有的  单个字符 因为一个字符都是   回文
 *
 *
 * @date:2020/2/3
 */
public class day10 {

  public String longestPalindrome(String s) {
    int length=s.length();
    boolean dp[][]=new boolean[length][length];

    if(s.length()<2){
      return s;
    }
    //初始化
    for(int i=0;i<length;i++){
      dp[i][i]=true;
    }
    int start=0;
    int maxLength=1;
    //开始动态规划

    for(int j=1;j<length;j++){
      for(int i=0;i<j;i++){
        if(s.charAt(i)==s.charAt(j)){
          if(j-i<3){
            dp[i][j]=true;
          }else{
            dp[i][j]=dp[i+1][j-1];
          }
        }else{
          dp[i][j]=false;
        }

        if(dp[i][j]){
          int currentLength=j-i+1;
          if(currentLength>=maxLength){
            maxLength=currentLength;
            start=i;
          }
        }
      }


    }
    return s.substring(start,start+maxLength);


  }
}
