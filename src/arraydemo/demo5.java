package arraydemo;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 这是是使用优先队列来做的，构建一个大顶堆 比堆顶小的就插入就可以了
 */
public class demo5 {

    public static void main(String[] args) {
        int [] a=new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(a, 4);
        for(int aa:integers)
        {
            System.out.println(aa);
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        for(int i=k/2-1;i>=0;i--)
        {
            createHeap(input,i,k-1);
        }
        for(int i=k;i<input.length;i++)
        {
            if(input[i]<input[0])
            {
                int tmp=input[0];
                input[0]=input[i];
                input[i]=tmp;
                createHeap(input,0,k-1);
            }
        }

        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            list.add(input[i]);
        }
        return list;

    }


    public static void createHeap(int[] input, int pos, int length) {
        int temp;
        int child;
        for (temp = input[pos]; 2 * pos + 1 <= length; pos = child) {

            child = 2 * pos;
            if (child + 1 <= length && input[child] < input[child + 1]) {
                child++;
            }
            if (input[child] > temp) {
                input[pos] = input[child];
            } else {
                break;
            }

        }
        input[pos]=temp;

    }


//    public void adjustMaxHeapSort(int[] input, int pos, int length){
//        int temp;
//        int child;
//        for(temp=input[pos]; 2*pos+1<=length; pos=child){
//            child=2*pos+1;
//            if(child<length && input[child]<input[child+1]){
//                child++;
//            }
//            if(input[child]>temp){
//                input[pos]=input[child];
//            }else{
//                break;
//            }
//        }
//        input[pos]=temp;
//    }


}
