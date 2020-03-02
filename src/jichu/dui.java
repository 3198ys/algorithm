package jichu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 堆包括构建堆，堆排序，使用的题主要就是  一大批数字找到最小的 n个数字  构建大顶堆，找最大的 几个数字 构建 小顶堆，，，堆排序，如果从大到小 构建 小顶堆，从小到大 构建大顶堆
 *
 * 注意注意注意 这里面 堆排序 和找最小的n个数有一点区别  在构建节点下沉的方法中 排序 child<length child+1<length  而最小的 n个数  child<=length child+1<=length
 * @date:2020/2/9
 */
public class dui {


  public static void main(String[] args) {
    int [] arr=new int[]{4,5,1,6,2,7,3,8};
    sort(arr);
    for(int a:arr){
      System.out.println(a);
    }
//    List<Integer> zuixiaojiweishu = zuixiaojiweishu(arr, 4);
//    for(Integer a:zuixiaojiweishu){
//      System.out.println(a);
//    }
  }
  public static void creatHead(int [] arr,int pos,int lenth){
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


  public static List<Integer> zuixiaojiweishu(int []arr,int k){
    for(int i=k/2;i>=0;i--){
      creatHead(arr,i,k-1);
    }
    for(int i=k;i<arr.length;i++){
      if(arr[i]<=arr[0]){
//        int tmq=arr[0];
        arr[0]=arr[i];
//        arr[i]=tmq;
        creatHead(arr,0,k-1);
      }
    }
    ArrayList<Integer> list=new ArrayList<>();
    for(int i=0;i<k;i++)
    {
      list.add(arr[i]);
    }
    return list;
  }
  public static void sort(int [] arr)
  {

    for(int i=arr.length/2;i>=0;i--){
      creatHead(arr,i,arr.length- 1);
    }
    for(int i=arr.length-1;i>=0;i--){
      int tmq=arr[0];
      arr[0]=arr[i];
      arr[i]=tmq;
      creatHead(arr,0,i);
    }
  }

}
