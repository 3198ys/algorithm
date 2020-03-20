package leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。


 这道题的思路就是  将左括号 全部放到栈中 因为 他这个 两个括号之间不允许有其他的值  所有两个括号一定是 挨着的  所以 只要 数组中最新的  和栈定的 匹配了 就可以出站  如果不匹配
 就可以返回false了 一个匹配不到 就都匹配不到了 而且  注意  在进行过程中 数组没有遍历完 stack为0 则就会 false说明第一个就是有括号
 */
public class day20 {
    public static void main(String[] args) {
        String s="(])";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    public static boolean isValid(String s) {

        Stack<Character> stack=new Stack<>();
        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{'){
                stack.push(chars[i]);
            }else{
                if(stack.size()>0){//这个地方一定要注意
                    Character peek = stack.peek();
                    if(peek=='(' && chars[i]==')'){
                        stack.pop();
                    }else if(peek=='[' && chars[i]==']'){
                        stack.pop();
                    }else if(peek=='{' && chars[i]=='}'){
                        stack.pop();
                    }else {
                        //这个地方一定要注意匹配不到就是false
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(stack.size()==0){
            return true;
        }else{
            return false;
        }
    }
}
