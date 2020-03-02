package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 大顶堆
 * 当只有几个数的时候 使用快拍来做
 * @date:2020/3/2
 */
public class day28 {

  public static void main(String[] args) {
    int []a=new int[]{4,5,1,6,2,7,3,8};
    ArrayList<Integer> integers = (ArrayList<Integer>) GetLeastNumbers_SolutionV2(a, 4);
    System.out.println(integers.toString());

  }
  public  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

    //构建大顶堆
   for(int i=k/2;i>=0;i--){
     creatHeap(input,i,k-1);
   }
   for(int j=k;j<input.length;j++){
     if(input[j]<=input[0]){
       input[0]=input[j];
       creatHeap(input,0,k-1);
     }

   }
   ArrayList<Integer> list=new ArrayList<>();
   for(int i=0;i<k;i++){
     list.add(input[i]);
   }
   return list;
  }

  public  void creatHeap(int [] input,int start,int end){
    int tmq=input[start];
    int child=2*start+1;
    while (child<=end){
      if(child+1<=end && input[child+1]>input[child]){
        child++;
      }
      if(tmq>=input[child]){
        break;
      }
      input[start]=input[child];
      start=child;
      child=2*child+1;
    }
    input[start]=tmq;
  }


  public static void creatHeadV2(int [] arr,int pos,int lenth){
    int temp=arr[pos];
    int child=2*pos+1;
    while (child<lenth){
      if(child+1<lenth && arr[child+1]>arr[child]){
        child++;
      }
      if(temp>=arr[child]){
        break;
      }
      arr[pos]=arr[child];
      pos=child;
      child=2*child+1;
    }
    arr[pos]=temp;

  }
/**
 * 第二种解法快排来做
 */
 public static int partition(int [] input,int start,int end){
   int left=start;
   int right=end;
   int target=input[start];
   while (left<right){
     while (left<right && target<=input[right]){
       right--;
     }
     while (left<right && target>=input[left]){
       left++;
     }
     if(left<right){
       int tmq=input[right];
       input[right]=input[left];
       input[left]=tmq;
     }

   }
   input[start]=input[left];
   input[left]=target;
   return left;
 }

  public  static ArrayList<Integer> GetLeastNumbers_SolutionV2(int [] input, int k) {

    int index=partition(input,0,input.length-1);
    while (index!=k-1){
      if(index<k-1){
        index=partition(input,index+1,input.length-1);
      }else if(index>k-1){
        index=partition(input,0,index-1);
      }
    }
    ArrayList<Integer> list=new ArrayList<>();
    for(int i=0;i<k;i++){
      list.add(input[i]);
    }
    return list;
  }
}
