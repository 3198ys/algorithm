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

        int count = getCount(input, 0, input.length - 1, k);
        ArrayList<Integer> list=new ArrayList();
        for(int i=0;i<k;i++)
        {
            list.add(input[i]);
        }
        return list;
    }


    public static int getCount(int [] array,int start,int end,int k)
    {
        int partion = partion(array, start, end);
        if(k<partion)
        {
            return getCount(array,start,partion-1,k);
        }else if(k>partion)
        {
            return getCount(array,partion+1,end,k);
        }
        return partion;
    }
    public static int partion(int [] array,int start,int end)

    {
        int index=array[start];
        while (start<end)
        {
            while (start<end&&array[end]>=index)
            {
                end--;
            }
            if(array[end]<index)
            {
                int tmq=array[start];
                array[start]=array[end];
                array[end]=tmq;
            }
            while (start<end&&array[start]<=index)
            {
                start++;
            }
            if(array[start]>index)
            {
                int tmq=array[end];
                array[end]=array[start];
                array[start]=tmq;
            }

        }
        return end;
    }
}
