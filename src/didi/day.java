package didi;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 这道题 要求是时间复杂度是o(n) 那么现在需要的就是把数据放在hash中，然后在取hash中去判断空间换时间，主要的思想就是 数据要放在hassset去重 之后再hashset中寻找，起始数字就是当前数字前面没有x-1,则这个数字就是起始数字，为啥要跳过因为如果有x-1那么就没必要重x开始了他一定比前面
 * 的短
 */
public class day {
    public int longestConsecutive(int[] nums) {

        //先把数据放入 set中去重 O(n)
        Set<Integer> numberSet=new HashSet<>();
        for(int a:nums){
            numberSet.add(a);
        }
        int lastLength=0;
        //再一次遍历数组 准备找出最长的莲须 第二次遍历一定要用set遍历，因为要去重一次
        for(int currentNum:numberSet){
            //循环的时候找到数字的起点没必要每个数字都要当做起点
            //只要当前数字前面没有 x-1的才能当做新的起点，因为如果有他一定不是最长的则没必要进行
            if(!numberSet.contains(currentNum-1)){
                int currentTmq = currentNum;
                //现在只有一个数字所以长度是1
                int currentLenth = 1;
                //开始在set中找 有没有x+1的 现在复杂度是O(1)
                while(numberSet.contains(currentTmq+1)){
                    //如果存在算出最长长度继续找
                    currentTmq=+1;
                    currentLenth=+1;
                }
                //要跳出循环的时候比较谁是最长的长度
                lastLength = Math.max(lastLength,currentLenth);
            }


        }
        return lastLength;

    }
}
