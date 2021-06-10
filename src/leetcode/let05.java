package leetcode;

/**
 * @Author ys 2021/6/9
 * @description 给你一个字符串 s，找到 s 中最长的回文子串
 * 结题思路就是动态规划，动态规划 动态规划也就是从小往上去找 一般像这种字符串的就是两层循环 就可以找到虽有的可能性 可以从短的字符串开始向上找 这里如果是一个字符的,都是回文字符串,当 首尾两个字符相等的时候切，
 *切长度小于3 的时候 小于三的话就说明长度在 是2  说明中间只有一个字符 则他一定是一个回文  如果长度 大于等于3 的时候这  db[i][j]=dp[i+1][j-1] 最后在比较一下长度就可以了
 */
public class let05 {
  public String longestPalindrome(String s) {

    if(s.length()<2){
      return s;
    }
    // 两个维度就是 数组的开始位置和结束位置
    boolean[][] dp=new boolean[s.length()][s.length()];
    for(int i=0;i<s.length();i++){
      dp[i][i]=true;
    }
    int max=1;
    int left=0;int right=0;
    for(int j=1;j<s.length();j++){
      for(int i=0;i<j;i++){
        //两层循环最正宗的可以找到所有的 字符串的循环
        if(s.charAt(i)==s.charAt(j)){
          if((j-i+1)<=3){
            dp[i][j]=true;
          }else{
            dp[i][j]=dp[i+1][j-1];
          }
        }else{
          dp[i][j]=false;
        }
        if(dp[i][j]){
          int length=j-i+1;
          if(length>max){
            max=length;
            left=i;
            right=j;
          }
        }
      }
    }
    return s.substring(left,left+max);
  }
}
