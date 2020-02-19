package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * 树结构的题 一般都用递归来做 如果两个数 不是空的 就从根节点开始比
 * @date:2020/2/17
 */
public class day18 {
  public boolean HasSubtree(TreeNode root1,TreeNode root2) {

    boolean result=false;
    if(root1!=null && root2!=null){

      if(root1.val==root2.val){
       result= digui(root1,root2);
      }
      if(!result){
        //根节点已经不相等了 比较 左子树 和那个 子树是否相等
        result=HasSubtree(root1.left,root2);
      }
      if(!result){
        result=HasSubtree(root1.right,root2);
      }
    }
    return result;
  }

  public boolean digui(TreeNode root1,TreeNode root2){
    if(root2 == null){
      // 说明 那个子树已经递归完了   说明都相等了
      return true;
    }
    if(root1 == null){

      //目标树都递归完了 还是没有找到对应的 所以返回false
      return false;
    }
    if(root1.val!=root2.val){
      return false;
    }
    //就是如果上面已经相等了  继续向下比较
    return digui(root1.left,root2.left) && digui(root1.right,root2.right);
  }
}
