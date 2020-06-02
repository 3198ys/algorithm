package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description:给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * @date:2020/5/28
 */
public class day60 {

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null){
            return null;
        }
        int index=0;
        TreeNode node1=pRoot;
        while (pRoot!=null){
            if(index>k){
                node1=node1.left;
            }
            pRoot=pRoot.left;
        }
        if(index<k){
            return null;
        }
        return node1;
    }

    TreeNode digui(TreeNode node,int k){
        int index=0;
        TreeNode node1=node;
        while (node!=null){
            if(index>k){
                node1=node1.left;
            }
            node=node.left;
        }
        return node1;
    }
}
