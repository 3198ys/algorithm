package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 这道题就是用两个栈来做 一个奇数栈一个偶数站
 * @date:2020/5/27
 */
public class day59 {

  public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

    Stack<TreeNode> jishu = new Stack<>();
    Stack<TreeNode> oushu = new Stack<>();
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    if (pRoot == null) {
      return list;
    }
    jishu.push(pRoot);
    int index = 1;
    while (!jishu.isEmpty() || !oushu.isEmpty()) {
      if (index % 2 != 0) {
        ArrayList<Integer> tmq = new ArrayList<>();
        while (!jishu.isEmpty()) {
          TreeNode pop = jishu.pop();
          tmq.add(pop.val);
          if (pop.left != null) {
            oushu.push(pop.left);
          }
          if (pop.right != null) {
            oushu.push(pop.right);
          }
        }
        if (!tmq.isEmpty()) {
          list.add(tmq);
          index++;
        }
      } else {
        ArrayList<Integer> tmq = new ArrayList<>();
        while (!oushu.isEmpty()) {
          TreeNode pop = oushu.pop();
          tmq.add(pop.val);
          if (pop.right != null) {
            jishu.push(pop.right);
          }
          if (pop.left != null) {
            jishu.push(pop.left);
          }
        }
        if (!tmq.isEmpty()) {
          list.add(tmq);
          index++;
        }
      }
    }
    return list;
  }
}
