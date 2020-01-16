package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一个二叉树，返回它的 前序 遍历。
 * @date:2020/1/16
 */
public class day07 {

  public List<Integer> preorderTraversal(TreeNode root) {

    List<Integer> list=new ArrayList<>();
    digui(list,root);
    return list;
  }

  public void digui(List<Integer> list,TreeNode root){

    if(root!=null){
      list.add(root.val);
      if(root.left!=null){
        digui(list,root.left);
      }

      if(root.right!=null){
        digui(list,root.right);
      }
    }
  }
}
