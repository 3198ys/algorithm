package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @date:2020/5/10
 */
public class day55 {


  ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    if(pRoot==null){
      return list;
    }
    Queue<TreeNode> queue=new LinkedList<>();
    queue.add(pRoot);
    ArrayList<Integer> tmq=new ArrayList<>();
    tmq.add(pRoot.val);
    list.add(tmq);
    int count=0;
    int heightLevel=1;
    while (!queue.isEmpty()){
      TreeNode poll = queue.poll();
      count++;
      if(poll.left!=null){
        queue.add(poll.left);
      }
      if(poll.right!=null){
        queue.add(poll.right);
      }
      if(count==heightLevel){
        count=0;
        heightLevel=queue.size();

        if(!queue.isEmpty()){

          Iterator<TreeNode> iterator = queue.iterator();
          ArrayList<Integer> tmq1=new ArrayList<Integer>();
          while (iterator.hasNext()){
            tmq1.add(iterator.next().val);
          }
          list.add(tmq1);
        }
      }

    }
    return list;
  }
}
