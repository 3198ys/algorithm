package leetcode;

public class day105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root=digui(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
    }

    public TreeNode digui(int[] preorder,int startpre,int endpre,int[] inorder,int startin,int endin){
        if(startpre>endpre || startin>endin){
            return null;
        }
        TreeNode node=new TreeNode(preorder[startpre]);
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[startpre]){
                node.left=digui(preorder,startpre+1,startpre+i-startin,inorder,startin,i-1);
                node.right=digui(preorder,startpre+i-startin+1,endpre,inorder,i+1,endin);
                break;
            }
        }
        return node;
    }
}
