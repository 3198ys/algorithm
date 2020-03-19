package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 * @date:2020/3/6
 */
public class day29 {
  public String PrintMinNumber(int [] numbers) {

    List<String> list=new ArrayList<>();

    for(int a:numbers){
      list.add(String.valueOf(a));
    }
    Collections.sort(list,new Comparator<String>(){


      @Override
      public int compare(String o1, String o2) {
        String a=o1+o2;
        String b=o2+o1;
        return a.compareTo(b);
      }
    });
    StringBuffer sb=new StringBuffer();
    for(String a:list){
      sb.append(a);
    }
    return sb.toString();
  }
  public static String PrintMinNumberV2(int [] numbers) {

    List<String> list=new ArrayList<>();

    for(int a:numbers){
      list.add(String.valueOf(a));
    }
    Collections.sort(list,new Comparator<String>(){


      @Override
      public int compare(String o1, String o2) {
        String a=o1+o2;
        String b=o2+o1;
        return a.compareTo(b);
      }
    });
    StringBuffer sb=new StringBuffer();
    for(String a:list){
      sb.append(a);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int [] nums=new int[]{3,32,321};
    String s = PrintMinNumberV2(nums);
    System.out.println(s);
  }
}
