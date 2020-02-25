package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 层序遍历
 * @date:2020/2/23
 */
public class day22 {
  public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

    ArrayList<Integer> list=new ArrayList<>();
    if(root == null){
      return list;
    }
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
      TreeNode poll = queue.poll();
      list.add(poll.val);
      if(poll.left!=null){
        queue.offer(poll.left);
      }
      if(poll.right!=null){
        queue.offer(poll.right);
      }
    }
    return list;
  }

}
