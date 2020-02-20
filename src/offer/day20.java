package offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法
 *
 * 这道题 首先就是要实现一个栈 用数组实现了一个站 注意的就是扩容  之后就是用有个stack来记录每次入栈或者出栈的时候此时的最小值
 * @date:2020/2/20
 */
public class day20 {

  int size=0;
  int min=Integer.MAX_VALUE;
  Stack<Integer> minstack=new Stack<>();
  Integer [] elements=new Integer[10];
  public void push(int node) {

    ensureCapacity(size+1);
    elements[size+1]=node;
    if(node<=min){
      minstack.push(node);
      min=minstack.peek();
    }else{
      minstack.push(min);
    }
  }

  private void ensureCapacity(int size) {
    int len=elements.length;
    if(size>len){
      int newLenth=(len*3)/2+1;
      elements= Arrays.copyOf(elements,newLenth);
    }
  }
  public void pop() {

    Integer top=top();
    if(top!=null){
      elements[size-1]=null;
    }
    size--;
    minstack.pop();
    min=minstack.peek();
  }

  public int top() {

    if(!empty()){
      if(size-1>=0){
        return elements[size-1];
      }
    }
    return (Integer) null;
  }
  public boolean empty(){
    return size == 0;
  }
  public int min() {

    return min;

  }
}
