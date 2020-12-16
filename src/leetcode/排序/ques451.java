package leetcode.排序;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ys 2020/12/16
 * @description 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 桶排序
 *
 */
public class ques451 {
  public static String frequencySort(String s) {

    if(s == null){
      return s;
    }
    char[] chars = s.toCharArray();
    Map<Character,Integer> map=new HashMap<>();
    for(char a:chars){
      map.put(a,map.getOrDefault(a,0)+1);
    }
    List<Character> [] list=new List[s.length()+1];
    for(char key:map.keySet()){
      Integer index = map.get(key);
      if(list[index] == null){
        list[index]=new ArrayList<>();
      }
      for(int i=0;i<index;i++){
        list[index].add(key);
      }
    }
    StringBuffer sb=new StringBuffer();
    for(int i=list.length-1;i>=0;i--){
      if(list[i] == null) continue;
      List<Character> characters = list[i];
      for(char a:characters){
        sb.append(a);
      }
    }
return sb.toString();
  }

  public static void main(String[] args) {
    String tree = frequencySort("tree");
    System.out.println(tree);
  }
}
