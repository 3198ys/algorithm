package offer;

import java.time.chrono.MinguoChronology;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @date:2020/2/19
 */
public class day19 {

  public void Mirror(TreeNode root) {

   if(root!=null){
     TreeNode tmq=root.left;
     root.left=root.right;
     root.right=tmq;
     if(root.left!=null){
       Mirror(root.left);
     }
     if(root.right!=null){
       Mirror(root.right);
     }
   }

  }
}
