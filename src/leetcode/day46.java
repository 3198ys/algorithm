package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一个没有重复数字的序列，返回其所有可能的全排列
 *
 * 此题使用了回溯法  回溯法 其实就是递归 只不过 他有一些条件就是在递归的过程中发现 这个解不是正确的解就会把它删掉，或者 递归到了最后 递归完毕了也会把它删掉
 * @date:2020/2/17
 */
public class day46 {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> tempList=new ArrayList<>();
    backtrack(list,tempList,nums);
    return list;
  }
  public void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
    if(tempList.size()==nums.length){
      //当找到了一组排列就将其加入到 list中 而且此时递归也就结束了
      list.add(new ArrayList<>(tempList));
    }else{
      for(int i=0;i<nums.length;i++){
        if(tempList.contains(nums[i])){
          continue;
        }
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        System.out.println("递归出来了  此时templist的内容"+tempList.toString()+"i的值"+i);
        //递归结束 去掉上一次进入递归的值 从新再去寻找
        tempList.remove(tempList.size()-1);
      }
    }
  }





















//  public List<List<Integer>> permute(int[] nums) {
//    //一个全局变量，用于保存所有集合
//    List<List<Integer>> list = new ArrayList<>();
//    //传入三个参数，没有附加参数
//    backtrack(list, new ArrayList<>(), nums);
//    return list;
//  }
//
//  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
//    //一个终结条件，也就是满足条件的时候
//    if(tempList.size() == nums.length){
//      //全局变量添加一个满足条件的集合
//      list.add(new ArrayList<>(tempList));
//    } else{
//      for(int i = 0; i < nums.length; i++){
//        if(tempList.contains(nums[i])) continue;
//        //如果tempList没有包含nums[i]才添加
//        tempList.add(nums[i]);
//        //递归调用，此时的tempList一直在变化，直到满足终结条件才结束
//        backtrack(list, tempList, nums);
//        System.out.println("tempList的内容:"+tempList+"-------"+"i的值:"+i);
//        //它移除tempList最后一个元素的作用就是返回上一次调用时的数据，也就是希望返回之前的节点再去重新搜索满足条件。这样才能实现回溯
//        tempList.remove(tempList.size() - 1);
//      }
//    }
//  }

  public static void main(String[] args){
//    int[] nums={1,2,3};
//    (new day46()).permute(nums);
  }
}
