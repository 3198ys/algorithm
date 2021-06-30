package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *回溯法联系
 *
 * @date:2020/2/19
 */
public class day39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> tmqList=new ArrayList<>();
    huisujianfa(list,candidates,target,tmqList,0);
    return list;
  }



  public static void huisujianfa(List<List<Integer>> list,int[] candidates, int target,List<Integer> tmqList,int start){
    if(target<0){return;}
    if(target == 0){
      list.add(new ArrayList<>(tmqList));
      return;
    }
    for(int i=start;i<candidates.length;i++){
      tmqList.add(candidates[i]);
      huisujianfa(list, candidates, target-candidates[i], tmqList, i);
      tmqList.remove(tmqList.size()-1);
    }
  }
  public static void huisujianfaV2(List<List<Integer>> list,int[] candidates, int target,List<Integer> tmqList){
    if(target<0){return;}
    if(target == 0){
      list.add(new ArrayList<>(tmqList));
      return;
    }
    for(int i=0;i<candidates.length;i++){
      tmqList.add(candidates[i]);
      huisujianfaV2(list, candidates, target-candidates[i], tmqList);
      tmqList.remove(tmqList.size()-1);
    }
  }
  public void huisu(List<List<Integer>> list,int[] candidates, int target,List<Integer> tmqList,int start){
    if(tmqList.size()>target){
      return;
    }else{

      Integer sum = sum(tmqList);
      if(sum==target){
        list.add(new ArrayList<>(tmqList));
      }else{
        for(int i=start;i<candidates.length;i++){
          tmqList.add(candidates[i]);
          huisu(list, candidates, target, tmqList,i);
          System.out.println("now:"+tmqList.toString()+"i="+i);
          tmqList.remove(tmqList.size()-1);
        }
      }
    }
  }

  private Integer sum(List<Integer> list){
    Integer sum=0;
    if(list!=null && list.size()>0){
      for(Integer a:list){
        sum+=a;
      }
    }
    return sum;
  }




  public static void huisu2(List<List<Integer>> list,int[] candidates, int target,List<Integer> tmqList,int start){
    if(tmqList.size()>target){
      return;
    }else{

      Integer sum = sum2(tmqList);
      if(sum==target){
        if(!list.contains(tmqList)){
          list.add(new ArrayList<>(tmqList));
        }

      }else{
        for(int i=start;i<candidates.length;i++){
          tmqList.add(candidates[i]);
          huisu2(list, candidates, target, tmqList,i);
          System.out.println("now:"+tmqList.toString()+"i="+i);
          tmqList.remove(tmqList.size()-1);
        }
      }
    }
  }

  private static Integer sum2(List<Integer> list){
    Integer sum=0;
    if(list!=null && list.size()>0){
      for(Integer a:list){
        sum+=a;
      }
    }
    return sum;
  }
  public static void main(String[] args) {
    int [] con=new int[]{1,2,8};
    List<List<Integer>> list=new ArrayList<>();
    List<Integer> tmqList=new ArrayList<>();
    huisujianfaV2(list,con,8,tmqList);
    System.out.println("result:"+list.toString());
  }
}
