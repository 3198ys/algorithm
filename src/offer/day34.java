package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @date:2020/3/19
 */
public class day34 {
  public int TreeDepth(TreeNode root) {
    if(root==null){
      return 0;
    }
    ArrayList<Integer> list=new ArrayList<>();
    ArrayList<Integer> tmqList=new ArrayList<>();
    digui(list,tmqList,root);
    Collections.sort(list, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });
    System.out.println(list.toString());
    return list.get(0);
  }

  public void digui(ArrayList<Integer> list, ArrayList<Integer> tmqList,TreeNode root){
    if(root.left==null && root.right==null){
      list.add(tmqList.size()-1);
      return;
    }
    tmqList.add(root.val);
    if(root.left!=null){
      digui(list,tmqList,root.left);
    }
    if(root.right!=null){
      digui(list, tmqList, root.right);
    }
    tmqList.remove(tmqList.size()-1);
  }
}
