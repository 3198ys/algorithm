package arraydemo;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 *
 *
 * 这个是利用了快拍的思想
 */
public class demo1 {


    public static void main(String[] args) {
        int [] aa=new int[]{4,2,1,4,2,4};
        int hello = MoreThanHalfNum_Solution(aa);
        System.out.println(hello);
    }
    public static int MoreThanHalfNum_Solution(int[] array) {


        int start=0;
        int end=array.length-1;
        int middle=array.length/2;
        int count = getCount(array, start, end, middle);
        int total=0;
        for(int i=0;i<array.length;i++)
        { if(array[i]==count)
            {
                total++;
            }
        }
        if(total*2>array.length)
        {
            return count;
        }else
        {
            return 0;
        }

    }


    public static int getCount(int[] array,int start,int end,int middle)
    {
        int index=getATarget(array,start,end);
        if(middle<index)
        {
            return getCount(array,start,index-1,middle);
        }else if(middle>index)
        {

            return getCount(array,index+1,end,middle);
        }
        return array[index];
    }

    public static int getATarget(int[] array, int start, int end) {
        int index = array[start];
        while (start < end) {
            while (start<end&&array[end] >=index) {
                end--;
            }
            if (array[end] <index) {
                int tmp = array[end];
                array[end] = array[start];
                array[start] = tmp;
            }
            while (start<end&&array[start] <=index) {
                start++;
            }
            if (array[start] >index) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
        return end;
    }
}
