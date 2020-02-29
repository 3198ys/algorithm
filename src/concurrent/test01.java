package concurrent;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: concurrent
 * @date:2020/2/27
 */
public class test01 {

  public static void main(String[] args) {
    int EXCLUSIVE_MASK = (1 << 16) - 1;

    System.out.println(Integer.toBinaryString(1));
    System.out.println(Integer.toBinaryString(EXCLUSIVE_MASK));
  }

}
