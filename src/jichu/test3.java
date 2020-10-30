package jichu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ys 2020/10/22
 * @description
 */
public class test3 {

  public static void main(String[] args) {

    System.out.println(Integer.toBinaryString(1<<13));
    System.out.println(Integer.toBinaryString(((1<<13)>>>1)&3));
    System.out.println();
  }
}
