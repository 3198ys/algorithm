package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *回溯法
 * @date:2020/2/29
 */
public class day26 {
  public ArrayList<String> Permutation(String str) {
    ArrayList<String> list=new ArrayList<>();
    List<Character> tmqList=new ArrayList<>();
    huisu(list,str.toCharArray(),tmqList);
    return list;
  }
  public void huisu(ArrayList<String> list,char[] chars,List<Character> tmqList){
    if(tmqList.size()>chars.length){
      return;
    }
    if(tmqList.size()==chars.length){
      StringBuffer sb=new StringBuffer();
      for(Character a:tmqList){
        sb.append(a);
      }
      list.add(sb.toString());
      return;
    }
    for(int i=0;i<chars.length;i++){
      if(tmqList.contains(chars[i])){
        continue;
      }
      tmqList.add(chars[i]);
      huisu(list, chars, tmqList);
      System.out.println("now"+tmqList.toString());
      tmqList.remove(tmqList.size()-1);
    }
  }
  public static void huisuV2(List<String> list,char[] chars,List<Character> tmqList){
    if(tmqList.size()>chars.length){
      return;
    }
    if(tmqList.size()==chars.length){
      StringBuffer sb=new StringBuffer();
      for(Character a:tmqList){
        sb.append(a);
      }
      list.add(sb.toString());
      return;
    }
    for(int i=0;i<chars.length;i++){
      if(tmqList.contains(chars[i])){
        continue;
      }
      tmqList.add(chars[i]);
      huisuV2(list, chars, tmqList);
      System.out.println("now"+tmqList.toString());
      tmqList.remove(tmqList.size()-1);
    }
  }

  public static void main(String[] args) {
    String a="abc";
    List<String> list=new ArrayList<>();
    List<Character> tmqList=new ArrayList<>();
    huisuV2(list,a.toCharArray(),tmqList);
    System.out.println("===============================");
    System.out.println(list.toString());
  }
}
