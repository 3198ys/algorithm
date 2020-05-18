package leetcode;

import java.util.Stack;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 找出数组中每个数右边第一个比它大的元素
 * 这道题是使用单调栈来做的
 * https://blog.csdn.net/smileiam/article/details/88732245
 * @date:2020/5/18
 */
public class dayrichang {

  public int[] getNum(int[] nums){

    int[] result=new int[nums.length];
    Stack<Integer> stack=new Stack<>();
    int index=0;
    stack.push(0);
    while (index<nums.length){
      if(!stack.isEmpty() && nums[stack.peek()]<nums[index]){
        result[stack.pop()]=nums[index];
      }else{
        stack.push(index);
        index++;
      }
    }
    if(!stack.isEmpty()){
      result[stack.pop()]=-1;
    }
    return result;
  }

}
