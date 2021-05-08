package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ys 2021/5/7
 * @description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 这道题有两种解法第一种利用回溯法 回溯就是递归嘛 递归的完成条件就是 当拼接的字符串的长度等于要求的2*n的时候就是完成的时候，当左括号的数量小于n的时候 增加左括号，当左括号的数量大于右括号的数量的时候 增加右括号
 *第二种结题思路 就是剩余的左括号的数量一定是小于右括号的数量的，所以只需要递归吧所有的符合的情况收集起来就可以了
 */
public class day22 {

  private List<String> res=new ArrayList<>();
  public List<String> generateParenthesis(int n) {

    List<String> result=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    huisu(result,sb,0,0,n);
    return result;
  }


public void huisu(List<String> result,StringBuilder sb,int left,int right,int max){

  if(sb.length() == 2*max){
    result.add(sb.toString());
    return;
  }
  //当 左边括号的数量小于max的时候 增加左括号
  if(left<max){
    sb.append("(");
    huisu(result,sb,left+1,right,max);
    sb.deleteCharAt(sb.length()-1);
  }
  //当 左括号的数量大于右括号的时候 增加右括号
  if(left>right){

    sb.append(")");
    huisu(result, sb, left, right+1, max);
    sb.deleteCharAt(sb.length()-1);
  }
}


  /**
   * 第二种解法

   */
  public void digui(String str,int left,int right){
    if(left==0 && right==0){
      res.add(str);
      return;
    }
    //当剩余left数量 等于剩余right的数量的时候 添加左括号
    if(left==right){

      digui(str+"(",left-1,right);
    }else if(left<right){
      //剩余左括号的数量小于右括号的数量的时候
      if(left>0){
        digui(str+"(",left-1,right);
      }
      digui(str+")",left,right-1);
    }
  }
}
