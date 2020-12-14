package jichu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ys 2020/10/22
 * @description
 */
public class test3 {

  public static void main(String[] args) {

    String aa="[9020728,9020726]";
    String dd="9020728,9020726";

    aa.replaceAll("\\[", "").replaceAll("\\]","");
    dd=dd.replaceAll("\\[", "").replaceAll("\\]","");
    System.out.println(aa);
    System.out.println(dd);
  }
}
