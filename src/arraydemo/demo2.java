package arraydemo;

/**
 *  数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class demo2 {
    public int MoreThanHalfNum_Solution(int [] array) {

        int count=0;
        int target=0;
        for(int i=0;i<array.length;i++)
        {
            if(count==0) {
                target = array[i];
            }
            if(target!=array[i])
            {
                count--;
            }else
            {
                count++;
            }

        }

        int total=0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]==target)
            {
                total++;
            }
        }
        if(total*2>array.length)
        {
            return target;
        }else
        {
            return 0;
        }



    }

}
