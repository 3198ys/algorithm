package offer;

import java.util.ArrayList;
import java.util.LinkedList;

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

        ArrayList<Integer> ret=new ArrayList<>();
        if(num==null){
            return ret;
        }
        if(num.length<size || size<1){
            return ret;
        }
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<size-1;i++){
            while (!list.isEmpty() && num[i]>num[list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
        }
        for(int i=size-1;i<num.length;i++){
         while (!list.isEmpty() && num[i]>num[list.getLast()]){
             list.removeLast();
         }
         list.addLast(i);
         if((i-list.getFirst())+1>size){
             list.removeFirst();
         }
         ret.add(num[list.getFirst()]);
        }
        return ret;
    }

}
