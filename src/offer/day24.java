package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 *回溯法
 * @date:2020/2/26
 */
public class day24 {

  public ArrayList<ArrayList<Integer>> FindPathV2(TreeNode root,int target) {

    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    if(root == null){

      return list;
    }
    ArrayList<Integer> tmqList=new ArrayList<>();
    digui(list,tmqList,root,target);
    return list;
  }

  public void digui(ArrayList<ArrayList<Integer>> list,List<Integer> tmqList,TreeNode root,int target) {
    if (target < 0) {
      return;
    }
    if (target == 0 && root.left == null && root.right == null) {
      list.add(new ArrayList<>(tmqList));
      return;
    }
    if (root != null) {

      tmqList.add(root.val);

      digui(list, tmqList, root.left, target - root.val);
      digui(list, tmqList, root.right, target - root.val);

      tmqList.remove(tmqList.size() - 1);
    }
  }
    public void digui(ArrayList<ArrayList<Integer>> list,List<Integer> tmqList,TreeNode root,int target,int sum){

      if(sum==target&& root.left==null&& root.right==null){
        list.add(new ArrayList<>(tmqList));
        return;
      }


        tmqList.add(root.val);

      if(root.left!=null){

        digui(list, tmqList, root.left, target,sum+root.val);
      }
      if(root.right!=null){

        digui(list, tmqList, root.right, target,sum+root.val);
      }

        tmqList.remove(tmqList.size()-1);


  }




  private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
  private ArrayList<Integer> list = new ArrayList<Integer>();
  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    if(root == null) return listAll;
    list.add(root.val);
    target -= root.val;
    if(target == 0 && root.left == null && root.right == null)
      listAll.add(new ArrayList<Integer>(list));
    FindPath(root.left, target);
    FindPath(root.right, target);
    list.remove(list.size()-1);
    return listAll;
  }
}
