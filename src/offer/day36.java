package offer;

import java.util.HashMap;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * 正确思路用异或来做  使用异或来做 数组中的所有数字都进行异或 这样的话 剩下的 就一定是 单独的两个数字的异或 这样 之后对对于剩下的那个数字a就要找到 两个数字的分界点  就是 第一次出现
 * 1的地方
 * @date:2020/3/23
 */
public class day36 {

  public static void main(String[] args) {
    int []a=new int[]{2,4,3,6,3,2,5,5};
    int [] num1=new int[1];
    int [] num2=new int[1];

  }

  public void FindNumsAppearOnceV2(int [] array,int num1[] , int num2[]){

    int tmq=0;
    if(array.length==2){
      num1[0]=array[0];
      num2[0]=array[1];
      return;
    }
    for(int i=0;i<array.length;i++){
      tmq^=array[i];
    }
    int index=0;
    //这一步就是找到  tmq中 第一个1的位置用于 后续区分  tmq中剩下的 两个单独数字标记用的
    while ((tmq&1)==0 && index<32){
      tmq=tmq>>=1;
      index++;
    }


    //这部就是已经区分出了  剩下的 tmq中两个数  只要第一次出现1 的 就应该是第一个数 这样和数组中的异或 剩下的一定是第一个数
    for(int i=0;i<array.length;i++){
      if(isBits(array[i],index)){
        num1[0]^=array[i];
      }else{
        num2[0]^=array[i];
      }
    }


  }


  public boolean isBits(int a,int index){
    return  ((a>>index)&1)==1;


  }
}
