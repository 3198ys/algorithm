package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ys 2021/4/23
 *
 * @description 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *     <p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *     题解：回溯法 现在map中存入 每个数字对应的字符串之后再用回溯法全排列
 */
public class ques17 {
  public static List<String> letterCombinations(String digits) {

    List<String> list = new ArrayList<>();
    if (digits.length() == 0) {
      return list;
    }
    Map<Character, String> map =
        new HashMap<Character, String>() {
          {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
          }
        };
    huisu(list,map,digits,0,new StringBuffer());
    return list;
    }

  /**
   *
   * @param list 要返回的值
   * @param digits 输入的数字
   * @param index 遍历的时候数字的下标
   * @param buffer 临时存字母的字符串
   * @param map 存放 数字和字母的对应关系
   */
  public static void huisu(List<String> list, Map<Character,String> map,String digits,int index,StringBuffer buffer){

    if(digits.length() == index){
      list.add(buffer.toString());
      //跳出此次的递归 返回上一级 就是 要删除当前最后一位的字母
    }else{
      char c = digits.charAt(index);
      String s = map.get(c);
      int letterLength=s.length();
      for(int i=0;i<letterLength;i++){
        buffer.append(s.charAt(i));
        huisu(list,map,digits,index+1,buffer);
        buffer.deleteCharAt(index);
      }
    }
  }

  public static void main(String[] args) {
    List<String> strings = letterCombinations("23");
    for(String a:strings){
      System.out.println(a);
    }
  }
}
