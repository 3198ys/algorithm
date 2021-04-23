package jichu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ys 2021/4/1
 * @description
 */
public class test2 {

  public static void main(String[] args) {
    double v = (Math.random() * 50) + 100;
    double v1 = v / 100;
    BigDecimal bigDecimal = new BigDecimal(v1);
    BigDecimal bigDecimal1 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    System.out.println(bigDecimal);
    System.out.println(bigDecimal1);
  }

}
