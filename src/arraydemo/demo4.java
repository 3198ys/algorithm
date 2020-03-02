package arraydemo;

import java.util.ArrayList;

public class demo4 {


    public static void main(String[] args) {
        int [] a=new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution1(a, 4);
        for(int aa:integers)
        {
            System.out.println(aa);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        ArrayList<Integer> leastNumbers = new ArrayList<Integer>();
        while(input==null || k<=0 || k>input.length)
            return leastNumbers;
        int start=0;
        int end=input.length-1;
        int index=partition(input,start,end);
        while(index!=k-1){
            if(index<k-1){
                start=index+1;
                index=partition(input,start,end);
            }else{
                end=index-1;
                index=partition(input,start,end);
            }
        }
        for(int i=0;i<k;i++){
            leastNumbers.add(input[i]);
        }
        return leastNumbers;
    }

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
