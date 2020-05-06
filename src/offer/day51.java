package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 链接：https://www.nowcoder.com/questionTerminal/6f8c901d091949a5837e24bb82a731f2
 * 来源：牛客网
 *
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @date:2020/5/6
 */
public class day51 {
  public boolean isNumeric(char[] str){
    String s=new String(str);
    String pattern="[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?";
    return s.matches(pattern);
  }
}
