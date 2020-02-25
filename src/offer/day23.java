package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *判断这个课树是不是一个二叉搜索树  二叉搜索树的 特点就是左子树 都比根节点小  柚子树都比根节点大 所以比较的过程就是 先遍历整个数组找到右子树的起点
 * 只要 这个数字比最后一个节点大 则这个树就是第一个右子树了  然后比较这颗右子树中有没有别根节点大的 比根节点大  则就不是一个二叉搜索树 之后就是递归  递归前面的 大的左子树里面的 是否
 * 是这个规则 右边的 右子树树里面是不是这个规则
 *
 * @date:2020/2/25
 */
public class day23 {

  public boolean VerifySquenceOfBST(int [] sequence) {

    if(sequence== null){
      return false;
    }


    return digui(sequence,0,sequence.length-1);
  }
  public boolean digui(int [] sequence,int start,int end){
    if(start>=end){
      return true;
      //说明已经到最后了 都是符合二叉树的规则的
    }
    int i=start;
    for(;i<=end;i++){
      if(sequence[i]>sequence[end]){
        //说明 这个i右边的都是根节点的右子树
        break;
      }
    }
    for(int j=i;j<end;j++){
      if(sequence[j]<sequence[end]){
        return false;
      }
    }
    //这个就是 先去判断前面那个大的 左子树 是否符合 二叉树 并且右边的 大的柚子树是否符合规矩
    return digui(sequence,start,i-1)&&digui(sequence,i,end-1);
  }
}
