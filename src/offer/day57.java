package offer;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 找这个节点的的下一个节点 因为这个节点已经输出 出来了所以他一定是没有左子树了  所以就如果他有右子树 则右子树最左边的节点就是他的下一个节点 如果没有
 * 右子树    则去找他的父节点就是他的下一个节点
 */
public class day57 {
    public TreeLinkNode GetNext(TreeLinkNode node){

        if(node==null){
            return null;
        }
        if(node.right!=null){
            node=node.right;
            while (node.left!=null){
                //不斷的去找嘴左边的节点
                node=node.left;

            }
            return node;
        }
        //此时noded的 有节点是空的 这时候就需要找他的父节点
        while (node.next!=null){
            if(node.next.left==node){
                return node.next;
            }
            node=node.next;
        }
        return null;
    }
}
