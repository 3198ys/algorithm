package jichu;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 最大公约数
 * @date:2020/3/29
 */
public class zuidagongyeushu {

  public static void main(String[] args) {
    int zuidagongyueshu = zuidagongyueshu(234, 56);
    System.out.println(zuidagongyueshu);
  }

  public static int zuidagongyueshu(int a,int b){
    int max=a>b?a:b;
    int min=a<b?a:b;
    if(max%min==0){
      return min;
    }else{
      return zuidagongyueshu(max%min,min);
    }
  }
}
