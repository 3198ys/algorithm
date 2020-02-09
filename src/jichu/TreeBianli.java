package jichu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: jichu
 * @date:2020/2/9
 */
public class TreeBianli {

  /**
   * 构建一个二叉树 输入的顺序 这个也是一个前序便利的顺序
   * @param list
   * @return
   */
  public static TreeNode createBinaryTree(LinkedList<Integer> list){
    TreeNode node=null;
    if(list==null || list.isEmpty()){
      return null;
    }
    Integer data=list.removeFirst();
    if(data!=null){
      node=new TreeNode(data);
      node.leftChild=createBinaryTree(list);
      node.rightChild=createBinaryTree(list);
    }
    return node;
  }

  /**
   * 前序遍历
   * @param node
   */
  public void qianxu(TreeNode node){
    if(node == null){
      return ;
    }
    System.out.println(node.data);
    qianxu(node.leftChild);
    qianxu(node.rightChild);

  }

  /**
   * 中序遍历
   * @param node
   */
  public void zhongxu(TreeNode node){
    if(node == null){
      return;
    }
    zhongxu(node.leftChild);
    System.out.println(node.data);
    zhongxu(node.rightChild);
  }

  /**
   * 后序遍历
   * @param node
   */
  public void houxu(TreeNode node){
    if(node == null){
      return;
    }
    zhongxu(node.leftChild);
    zhongxu(node.rightChild);
    System.out.println(node.data);
  }

  /**
   * 二叉树的层序遍历  使用队列来做的
   * @param node
   */
  public void cengxu(TreeNode node){
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(node);
    while (!queue.isEmpty()){
      TreeNode poll = queue.poll();
      System.out.println(poll.data);
      if(poll.leftChild != null){
        queue.offer(poll.leftChild);
      }
      if(poll.rightChild != null){
        queue.offer(poll.rightChild);
      }
    }
  }
}
