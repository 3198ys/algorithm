package offer;

import java.util.*;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 使用层次遍历 可以统计树的高度 一定记住  2 就是利用递归来做
 * @date:2020/3/19
 */
public class day34 {
//  public int TreeDepth(TreeNode root) {
//    if(root==null){
//      return 0;
//    }
//    ArrayList<Integer> list=new ArrayList<>();
//    ArrayList<Integer> tmqList=new ArrayList<>();
//    digui(list,tmqList,root);
//    Collections.sort(list, new Comparator<Integer>() {
//      @Override
//      public int compare(Integer o1, Integer o2) {
//        return o2-o1;
//      }
//    });
//    System.out.println(list.toString());
//    return list.get(0);
//  }
//
//  public void digui(ArrayList<Integer> list, ArrayList<Integer> tmqList,TreeNode root){
//    if(root.left==null && root.right==null){
//      list.add(tmqList.size()-1);
//      return;
//    }
//    tmqList.add(root.val);
//    if(root.left!=null){
//      digui(list,tmqList,root.left);
//    }
//    if(root.right!=null){
//      digui(list, tmqList, root.right);
//    }
//    tmqList.remove(tmqList.size()-1);
//  }

  /**
   * 层序遍历来做
   * @param root
   * @return
   */
  public int TreeDepth(TreeNode root) {

    if(root==null){
      return 0;
    }
    Queue<TreeNode> queue=new LinkedList<>();
    queue.add(root);
    int hight=0;
    /**
     * 这个代表了每层遍历的节点数
     */
    int count=0;
    /**
     * 代表了 下一层有的节点数 首先设为1就是  第一层就有一个节点
     */
    int nextCount=1;
    while (queue.size()!=0){

      TreeNode tmq=queue.poll();
      count++;
      if(tmq.left!=null){
        queue.add(tmq.left);
      }
      if(tmq.right!=null){
        queue.add(tmq.right);
      }
      if(count==nextCount){
        /**
         * 这个判断条件就是 这层 遍历 已经结束了count可以重新设为 0 深度可以加一了 nextCount也要重新 设置 现在 queue中的节点都是下一层的节点
         *
         *
         *
         */
        nextCount=queue.size();
        count=0;
        hight++;
      }
    }
    return hight;
  }

  public int TreeDepthV2(TreeNode root){

    if(root==null){
      return 0;
    }
    int left=TreeDepthV2(root.left);
    int right=TreeDepthV2(root.right);
    return Math.max(left,right)+1;
  }
}
