package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @date:2020-01-08
 */
public class day05 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        TreeNode node=digui(pre,0,pre.length-1,in,0,in.length-1);
        return node;
    }

    public TreeNode digui(int [] pre,int preStart,int preEnd,int[] in ,int inStart,int inEnd){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        TreeNode root=new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
                //相等的时候就是这个树的根节点

                //从现在 这边就开始 递归了，这个递归主要就是找到根节点只有放到父节点的左边或者右边，这里递归就回把
                //左子树和右子树分别找到  i就是根节点的位置 所以在ide左边都是左子树，i的右边都是右子树
                //所以   instart到i-1的数字全部都是zuo子树上的 数字，而在前序遍历中  左子树的个数就是 i-instart 所以在前序遍历中  左子树的节点就是
                //从preStart+1（因为第一个就是 根节点） preStart+1到 preStart+i-inStart

                /**
                 * 右子树 同理  右子树中在前序遍历中就是上面 的最后一个加1，中序遍历 同理
                 */
                root.left=digui(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=digui(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
                break;
            }
        }
        return root;
    }
}
