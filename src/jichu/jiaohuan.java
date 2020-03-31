package jichu;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: jichu
 * @date:2020/3/29
 */
public class jiaohuan {

  public static void main(String[] args) {
    swap(2,4);
  }

  public static void swap(int a,int b){
    System.out.println(a+":"+b);
    a=a^b;
    b=a^b;
    a=a^b;
    System.out.println(a+":"+b);

  }
}
