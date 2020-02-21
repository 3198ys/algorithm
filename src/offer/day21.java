package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *就是模拟入栈出栈
 * @date:2020/2/21
 */
public class day21 {

  public boolean IsPopOrder(int [] pushA,int [] popA) {

    Stack<Integer> stack=new Stack<>();
    int length=popA.length-1;
    int index=0;
    for(int a:pushA){
      stack.push(a);
      while (index<=length){
        Integer peek = stack.peek();
        if(peek==popA[index]){
          index++;
          stack.pop();
        }else{
          break;
        }
      }
    }
    if(stack.isEmpty()){
      return true;
    }else{
      return false;
    }
  }
  public static boolean IsPopOrderV2(int [] pushA,int [] popA) {

    Stack<Integer> stack=new Stack<>();
    int length=popA.length-1;
    int index=0;
    for(int a:pushA){
      stack.push(a);
      while (index<=length){
        Integer peek = stack.peek();
        if(peek==popA[index]){
          index++;
          stack.pop();
        }else{
          break;
        }
      }
    }
    if(stack.isEmpty()){
      return true;
    }else{
      return false;
    }
  }

  public static boolean IsPopOrderV3(int [] pushA,int [] popA) {

    int index=0;
    LinkedList<Integer> stack=new LinkedList<>();
    for(int i=0;i<pushA.length;i++)
    {
      stack.addLast(pushA[i]);

      while (!stack.isEmpty())
      {
        Integer last = stack.getLast();
        if(last==popA[index])
        {
          stack.removeLast();
          index++;
        }
      }

    }
    return stack.isEmpty();
  }
  public static void main(String[] args) {
    int []push=new int[]{1,2,3,4,5};
    int []pop=new int[]{4,3,5,1,2};
    boolean b = IsPopOrderV2(push, pop);
    System.out.println(b);
  }
}
