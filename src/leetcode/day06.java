package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:给定一个二叉树，返回它的中序 遍历。
 * @date:2020/1/16
 */
public class day06 {

  public List<Integer> inorderTraversal(TreeNode root) {

    List<Integer> list=new ArrayList<>();
    digui(list,root);
    return list;
  }

  public void digui(List<Integer> list,TreeNode root){

    if(root!=null){
      if(root.left!=null){
        digui(list,root.left);
      }
      list.add(root.val);
      if(root.right!=null){
        digui(list,root.right);
      }
    }
  }
}
