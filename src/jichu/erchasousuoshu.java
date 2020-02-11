package jichu;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 二叉搜索树
 * @date:2020/2/10
 */
public class erchasousuoshu {

  /**
   * 判断是否存在
   * @param target
   * @param root
   * @return
   */
  public boolean contains(int target,BinaryNode root){
    if(root == null){
      return false;
    }
    int result=compare(target,root.data);
    if(result<0){
      return contains(target,root.left);
    }else if(result>0){
      return contains(target,root.right);
    }else{
      return true;
    }

  }

  public int findMin(BinaryNode root){
    if(root==null){
      return -1;
    }else if(root.left==null){
      return root.data;
    }else{
      return findMin(root.left);
    }


  }

  public int findMax(BinaryNode root){
    if(root == null){
      return -1;
    }else if(root.right==null){
      return root.data;
    }else{
      return findMax(root.right);
    }
  }


  public BinaryNode insert(int target,BinaryNode root){
    if(root == null){
      return new BinaryNode(target,null,null);
    }
    int result=compare(target,root.data);
    if(result<0){
      //说明在左子树上
      root.left=insert(target,root.left);
    }else if(result>0){
      root.right=insert(target, root.right);
    }else{

    }
    return root;
  }

  /**
   * 删除 是最复杂的  删除如果是一个叶子节点直接删除，如果只有一个子节点  这直接删除 删除后他的父节点直接指向他的子节点，最复杂的就是     被删除节点他有两个子节点这样的话，需要找到他的 右子树的最小的节点  与他替换 并删除这个最小的节点
   * @param target
   * @param root
   * @return
   */
  public BinaryNode remove(int target,BinaryNode root){

    if(root == null){
      return root;
    }
    int reulst=compare(target,root.data);
    if(reulst<0){
      //就是他的左子树的某一个节点会被删除
      root.left=remove(target,root.left);
    }else if(reulst>0){
      root.right=remove(target,root.right);
    }else if(root.left!=null && root.right!=null){
      root.data=findMin(root.right);//替换这个被删除节点的值
      //删除柚子树总最小的 那个节点
      root.right=remove(root.data,root.right);
    }else{
      //这种情况就是 只有一个单的子节点
      root=root.left!=null?root.left:root.right;
    }
    return root;
  }

  private int compare(int target,int data){
    if(target==data){
      return 0;
    }else if(target>data){
      return 1;
    }else{
      return -1;
    }
  }
}
