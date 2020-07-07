package leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author ys 2020/7/7
 * @description 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 这道题的 题解是需要 在hashSet中先存放 元音字母 之后领用双指针的方式 左右一起找，如果 不是元音字母
 * 则顺利的放到新的数组里面左右都是 顺利放到新的 数组里面 如果左右是元音字母则调用换顺序
 */
public class ques345 {

  private final static HashSet<Character> vowels=new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

  public String reverseVowels(String s) {

    if(s==null|| s.equals("")){
      return null;
    }
    int left=0;
    int right=s.length()-1;
    char[] result=new char[s.length()];
    while (left<=right){
      char leftChar=s.charAt(left);
      char rightChar=s.charAt(right);
      if(!vowels.contains(s.charAt(left))){
        result[left++]=leftChar;
      }else if(!vowels.contains(s.charAt(right))){
        result[right--]=rightChar;
      }else{
        //交换顺序
        result[left++]=rightChar;
        result[right--]=leftChar;
      }
    }
    return new String(result);
  }
}
