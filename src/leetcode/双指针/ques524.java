package leetcode.双指针;

import java.util.List;

/**
 * @Author ys 2020/7/23
 *
 * @description 524. 通过删除字母匹配到字典里最长单词
 *     给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串
 *
 *     这道题的思路就是 一个指针指 指原来的字符串另一指字典指 相等就移动指针 最后判断字典指针的值是否 和字典长度相同 相同则返回
 *
 */
 public class ques524 {
  public String findLongestWord(String s, List<String> d) {

    String longestString="";
    for(String target:d){
      int longest=longestString.length(); int l2=target.length();
      if(longest>l2 || (longest==l2 && longestString.compareTo(target)<0)){
        continue;
      }

      boolean sub = isSub(s, target);
      if(sub){
        longestString=target;
      }
    }
return longestString;
  }

  private boolean isSub(String s,String target){
    int i=0;int j=0;
    while (i<s.length() && j<target.length()){
      if(s.charAt(i) == target.charAt(j)){
        j++;
      }
      i++;
    }
    return j==target.length();
  }
}
