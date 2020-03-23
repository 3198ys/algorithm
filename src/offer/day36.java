package offer;

import java.util.HashMap;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 正确思路用异或来做
 * @date:2020/3/23
 */
public class day36 {

  public static void main(String[] args) {
    int []a=new int[]{2,4,3,6,3,2,5,5};
    int [] num1=new int[1];
    int [] num2=new int[1];
    FindNumsAppearOnce(a,num1,num2);
  }
  public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<array.length;i++){
      if(!map.containsKey(array[i])){
        map.put(array[i],1);
      }else{
        Integer integer = map.get(array[i]);
        map.put(array[i],++integer);
      }
    }
    int count=0;
    for(int i=0;i<array.length;i++){
      if(map.get(array[i])==1){
        if(count==0){
          num1[0]=array[i];
          count++;
        }else{
          num2[0]=array[i];
        }
      }
    }
  }
}
