package leetcode.贪心算法;

/**
 * @Author ys 2021/1/12
 * @description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 使用双指针
 */
public class ques392 {
  public boolean isSubsequence(String s, String t) {

    int n=s.length();int m=t.length();
    int i=0;int j=0;
    while (i<n && j<m){
      if(s.charAt(i) == t.charAt(j)){
        i++;
      }
      j++;
    }
    return i == n;
  }
}
