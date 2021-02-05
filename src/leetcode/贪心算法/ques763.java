package leetcode.贪心算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ys 2021/2/5
 * @description 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * 这道题的思路 主要是 现在找到到字符串中每个字符出现的最后出现的位置  之后循环这个字符串 找到循环过的字符中最后出现的位置，之后将该位置和i（for 循环的指针）（比较如果相等  则这一段距离就是一个字符串片段
 * 这段的目的就是遇到就切分 这样可以更多的片段
 */
public class ques763 {
  public List<Integer> partitionLabels(String S) {

    int[] index=new int[26];
    for (int i = 0; i < S.toCharArray().length; i++) {
      index[S.charAt(i) - 'a'] = i;
    }
    int start=0;int end=0;
    List<Integer> partitions=new ArrayList<>();
    for(int i=0;i<S.length();i++){
      end=Math.max(end,index[S.charAt(i)-'a']);
      if(i==end){
        partitions.add(end-start+1);
        start=end+1;
      }
    }
    return partitions;
  }
}
