package jichu;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: jichu
 * @date:2020/2/8
 */
public class maopao {

  public static void main(String[] args) {
    int [] arr=new int[]{10,13,2,67,1,34,4,11,12};
    sort(arr);
    for(int a:arr){
      System.out.println(a);
    }
  }

  public static void sort(int [] arr){
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr.length-1-i;j++){
        if(arr[j]>arr[j+1]){
          int tmq=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=tmq;
        }
      }
    }
  }




}
