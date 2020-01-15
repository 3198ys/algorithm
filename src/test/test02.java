package test;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: test
 * @date:2020/1/15
 */
public class test02 {

  public static void main(String[] args) {
    Long a=-1L;
    Integer b=-1;
    String s = Integer.toBinaryString(b);
    System.out.println(s);

    System.out.println(Integer.toBinaryString(b<<2));
    System.out.println(Integer.toBinaryString(b^(b<<2)));
    System.out.println((a<<2) ^ a);
  }

}
