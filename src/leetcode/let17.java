package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ys 2021/6/22
 * @description 此题正宗回溯法 借此机会正好整理于一下回溯法
 */
public class let17 {
  public List<String> letterCombinations(String digits) {

    List<String> result=new ArrayList<>();
    if(digits==null || digits.length()==0)
    {
    return result;
    }
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
      put('2', "abc");
      put('3', "def");
      put('4', "ghi");
      put('5', "jkl");
      put('6', "mno");
      put('7', "pqrs");
      put('8', "tuv");
      put('9', "wxyz");
    }};

    huisu(result,phoneMap,new StringBuffer(),digits,0);
    return result;
  }
  public void huisu(List<String> result,Map<Character, String> phoneMap,StringBuffer sb,String digits,int index){
    if(index == digits.length()){
      result.add(sb.toString());
    }else{
      char c = digits.charAt(index);
      String letters = phoneMap.get(c);
      int length=letters.length();
      for(int i=0;i<length;i++){
        sb.append(letters.charAt(i));
        //回溯开始讲 index+1进入到下一个位置的寻找
        huisu(result,phoneMap,sb,digits,index+1);
        //上一个位置的寻找完毕之后将上一个位置找到的字符删掉，之后寻找 这个位置在当前字符串中的下一个位置
        sb.deleteCharAt(index);
      }
    }
  }


  /**
   * 另一个典型的回溯 给出一个字符串 找出这个字符串的所有不重复的排列 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
   * @param str
   * @return
   */


  public void shuzihuisu(List<String> result,String str,List<Character> tmq){
    if(tmq.size() ==str.length()){
      StringBuffer sb=new StringBuffer();
      for(Character c:tmq){
        sb.append(c);
      }
      result.add(sb.toString());
    }else{
      for(int i=0;i<str.length();i++){
        if(tmq.contains(str.charAt(i))){
          continue;
        }
        tmq.add(str.charAt(i));
        shuzihuisu(result,str,tmq);
        tmq.remove(tmq.size()-1);
      }
    }
  }

}
