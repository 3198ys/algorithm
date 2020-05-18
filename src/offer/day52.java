package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: offer
 * @date:2020/5/7
 */
public class day52 {

  public List<Integer> getNode(TreeNode node){
    List<Integer> list=new ArrayList<>();
    digui(node,list);
    return list;
  }

  public void digui(TreeNode node,List<Integer> list){
    if(node!=null){
      list.add(node.val);
      if(node.left!=null){
        digui(node.left,list);
      }
      if(node.right!=null){
        digui(node.right,list);
      }
    }

  }

  public void nodigui(TreeNode node,List<Integer> list){
    Stack<TreeNode> stack=new Stack<>();
    TreeNode treeNode=node;
    while (treeNode!=null || !stack.isEmpty()){
      while (treeNode!=null){
        list.add(treeNode.val);
        stack.push(treeNode);
        treeNode=treeNode.left;
      }
      if(!stack.isEmpty()){
        treeNode=stack.pop();
        treeNode=treeNode.right;
      }
    }
  }

//  public void getUserId(Integer userId){
//    select department_id from user_department where user_id=a and is_leader=1;
//    Stack<Integer> stack=new Stack<Integer>();
//    stack.add(department_id);
//    List<Integer> list=new ArrayList<>();
//    while (!stack.isEmpty()){
//      Integer pop = stack.pop();
//      list.add(pop);
//      select * from department where parent_id=pop;
//      stack.add(id);
//    }
//    select * from user_department where department_id in (list);
//  }



}
