package offer;

import java.util.ArrayList;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @date:2020/6/4
 */
public class day63 {

    public static void main(String[] args) {

        int[] a=new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> arrayList = maxInWindows(a, 3);
        System.out.println(arrayList.toString());
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {

        ArrayList<Integer> list=new ArrayList<>();
        if(size==0){
            return list;
        }
        for(int i=0;i<num.length;i++){
            int min=num[i];
            for(int j=i;j<i+size && i+size<=num.length;j++){
                if(num[j]>min){
                    min=num[j];
                }
            }
            if(i+size<=num.length){
                list.add(min);
            }
        }
        return list;
    }

}
