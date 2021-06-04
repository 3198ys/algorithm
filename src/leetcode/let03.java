package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author ys 2021/6/3
 * @description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class let03 {

  public int lengthOfLongestSubstring(String s) {

    HashSet<Character> set=new HashSet<>();


    //定义 两个指针 滑动窗口就是 定义窗口 开始和结尾两个指针  用来表示窗口的长度

    int i=0;int j=0;
    int max=0;//记录最长的长度
    char[] chars = s.toCharArray();
    while (i<chars.length&& j<chars.length){
      if(!set.contains(chars[i])){
        set.add(chars[i++]);
        max=Math.max(max,i-j);
      }else{
        set.remove(chars[j++]);
      }
    }
    return max;
  }
}
