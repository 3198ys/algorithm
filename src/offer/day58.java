package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @date:2020/5/20
 */
public class day58 {
    boolean isSymmetrical(TreeNode pRoot)
    {

        if(pRoot==null){
            return true;
        }
        return comRoot(pRoot.left,pRoot.right);
    }

    public boolean comRoot(TreeNode left,TreeNode right){

        if(left == null) return right==null;//这个判断就是如果left是空的话  如果right不是空的 则就不是对称的返回false 如果 right是空的返回true
        if(right == null) return false;//到了这一步 说明 left已经不是空的了  所以 right是null的话 只能返回false
        if(left.val!=right.val){
            return false;
            //这个地方不能判断  相等返回true的原因就是如果 这时候返回了true则地柜就中断了  下面都不能返回了
        }
        return comRoot(left.left,right.right) && comRoot(left.right,right.left);
    }
}
