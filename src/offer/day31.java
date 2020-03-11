package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * @date:2020/3/9
 */
public class day31 {
  public static int FirstNotRepeatingChar(String str) {
   Map<Character,Integer> resultmap=new HashMap<>();
   for(int i=0;i<str.toCharArray().length;i++){
     if(!resultmap.containsKey(str.charAt(i))){
       resultmap.put(str.charAt(i),1);
     }else{
       Integer integer = resultmap.get(str.charAt(i));
       resultmap.put(str.charAt(i),++integer);
     }
   }
    for(int i=0;i<str.toCharArray().length;i++){
      if(resultmap.get(str.charAt(i))==1){
        return str.indexOf(str.charAt(i));
      }
    }
    return -1;

  }

  public static void main(String[] args) {
    String a="aaaddccce";
    int i = FirstNotRepeatingChar(a);
    System.out.println(i);
  }
}
