package offer;

import java.util.ArrayList;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * @date:2020/3/27
 */
public class day38 {


  public static void main(String[] args) {
    int []a=new int[]{1,2,3,4,5,6,7,9,10,11,12};
    ArrayList<Integer> integers = FindNumbersWithSum(a, 13);
    System.out.println(integers);
  }
  public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {

    int left=0;
    int right=array.length-1;
    ArrayList<Integer> list=new ArrayList<>();
    int min=Integer.MAX_VALUE;
    int a=0;int b=0;
    while (left<right){

      if(array[left]+array[right]==sum){
        if(array[left]*array[right]<=min){
          min=array[left]*array[right];
          a=array[left];
          b=array[right];
        }
        left++;
        right--;
      }else if(array[left]+array[right]<sum){
        left++;
      }else{
        right--;
      }
    }
    if(min!=Integer.MAX_VALUE){

      list.add(a);
      list.add(b);
    }
    return list;
  }
}
