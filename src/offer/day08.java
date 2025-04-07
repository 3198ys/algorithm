package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class day08 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        stack1.push(node);
    }

    public int pop() {


        if (stack2.isEmpty()) {

            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }




    Stack<Integer> stack3 =  new Stack<Integer>();
    Stack<Integer> stack4 =  new Stack<Integer>();

    //这道题主要就是 队列是先入先出，占是先入后出  两个占第一个占正常存入 第二个占 存入的顺序个第一个占正好相反 这样就能实现队列的先进先出
    public void push1(int a){
        stack3.push(a);
    }

    public int pop2(){
        if(stack4.isEmpty()){
            //如果反过来的占时空则需要
            while(stack3.size()>0){
                //将stack3 的元素吐出来 这就是先入后出  然后放在 stack4里面 之后stat4吐出来的时候就会先吐出来 最近push进来的
                stack4.push(stack3.pop());
            }
        }
        return stack4.pop();
    }
}

