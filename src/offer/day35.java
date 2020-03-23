package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 是否是一个平衡二叉树的 条件就是左子树的高度和右子树的高度相差小于等于1  切左子树和右子树都是  哦平衡二叉树
 *
 * 思想就是利用找树的高度来做   参考 34
 *
 * @date:2020/3/22
 */
public class day35 {


    /**
     * 这种接法有点问题就是 一个节点要遍历了两遍  最好的 接法 就是 就底层开始判断 子树不是  平衡二叉树 则  上面就不可能是 平衡二叉树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {

        if(root==null){
            return true;
        }
        return Math.abs(getTreeLength(root.left)-getTreeLength(root.right))<=1 && IsBalanced_Solution(root.left) &&IsBalanced_Solution(root.left);
    }

    public int getTreeLength(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getTreeLength(root.left);
        int right=getTreeLength(root.right);
        return Math.max(left,right)+1;
    }

    public boolean IsBalanced_SolutionV2(TreeNode root){
        if(root==null){
            return true;
        }
        return diguipandu(root)!=-1;
    }

    public int diguipandu(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=diguipandu(node.left);
        if(left==-1) return -1;

        int right=diguipandu(node.right);
        if(right==-1) return -1;
        return Math.abs(left-right)>1?-1:1+Math.max(left,right);
    }
}
