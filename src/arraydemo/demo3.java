package arraydemo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class demo3 {

    public static void main(String[] args) {
int [] a=new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(a, 3);
        for(int aa:integers)
        {
            System.out.println(aa);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        int start=0;
        int end=input.length-1;
        int index=partition(input,start,end);
        while (index!=k-1)
        {
            if(index<k-1)
            {
                index=partition(input,index+1,end);
            }else
            {
                index=partition(input,start,index-1);
            }
        }
        ArrayList<Integer> list=new ArrayList();
        for(int i=0;i<k;i++)
        {
            list.add(input[i]);
        }
        return list;
    }


    public static int getCount(int [] array,int start,int end,int k)
    {
        int partion = partition(array, start, end);
        if(k-1<partion)
        {
            return getCount(array,start,partion-1,k);
        }else if(k+1>partion)
        {
            return getCount(array,partion+1,end,k);
        }
        return partion;
    }
//    public static int partition(int [] array,int start,int end)
//
//    {
//        int index=array[start];
//        while (start<end)
//        {
//            while (start<end&&array[end]>=index)
//            {
//                end--;
//            }
//            if(array[end]<index)
//            {
//                int tmq=array[start];
//                array[start]=array[end];
//                array[end]=tmq;
//            }
//            while (start<end&&array[start]<=index)
//            {
//                start++;
//            }
//            if(array[start]>index)
//            {
//                int tmq=array[end];
//                array[end]=array[start];
//                array[start]=tmq;
//            }
//
//        }
//        return end;
//    }

    private static int partition(int[] arr, int start,int end){
        int pivotKey=arr[start];
        while(start<end){
            while(start<end && arr[end]>=pivotKey)
                end--;
            swap(arr,start,end);
            while(start<end && arr[start]<=pivotKey)
                start++;
            swap(arr,start,end);
        }
        return start;
    }

    private static void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
