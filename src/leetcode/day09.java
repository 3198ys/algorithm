package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 使用动态规划来做   这里数组 dp[i][j]=s[i,j]代表了从i到j之间的子字符串是否是回文，这里判断这个子字符串是不是回文的方法就是
 * 如果 这个子字符串的头和尾是相同的 剩下的字符串是回文的话  则这个字符串就是回文字符串
 * dp[i][j]=(s[i]==s[j] and dp[i+1][j-1]) 这样的  则这个子字符串就是  回文字符串，使用动态规划 都要使用初始化哦,这里 如果 首位的 字符是相同想 则  中间的  j-1-(i+1)+1<2这个长度 小于2  则
 * 就说明  这个  子字符串 是  回温了   所以  最终的条件就是 首位相同而且   j-i<3;则这个就是 回文
 *
 * 首先就是要初始化一个 dp[][] 的二维数组  之后  在对角线上的字符串 也就是只有一个字符的 字符串都是回文的字符串
 *
 * 1 2 3 4 5
 */
public class day09 {
    public String longestPalindrome(String s) {

        if(s.length()<2){
            return s;
        }
        boolean [][] db=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            db[i][i]=true;
        }
        int maxlength=1;//最大长度应该是一 因为 单个字符也是 回文
        int start=0;
        int length=0;
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i<3){
                        db[i][j]=true;
                    } else{
                        /**
                         * 这时候说明  首尾已经相同了但是   中间的 字符串很长 而且 需要根据他的 里面的  字符串来判断  如果里面的字符串 是 回文 则说明 他也是回文
                         */
                        db[i][j]=db[i+1][j-1];
                    }
                }else {
                    db[i][j]=false;
                }

                if(db[i][j]){
                     length=j-i+1;
                    if(length>=maxlength){
                        maxlength=length;
                        start=i;
                    }
                }
            }
        }

        return s.substring(start,start+maxlength);

    }
}
