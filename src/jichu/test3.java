package jichu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ys 2020/10/22
 * @description
 */
public class test3 {

  public static void main(String[] args) {

    List<String> aa=new ArrayList<>();
    aa.add("aaaa");
    aa.add("aaaa");
    aa.add("aaaa");
    aa.add("aaaa");
    List<String> strings = aa.subList(0, aa.size());
    for(String c:strings){
      System.out.println(c);
    }
  }
}
