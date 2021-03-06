package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ys 2021/5/17
 *
 * @description 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *     <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *     <p>你可以按任意顺序返回答案。
 */
public class let01 {
  public static void main(String[] args) {
    // --1621240764345
    // 2021-05-17 16:40:32,928 - com.youdao.kids.crm.service.offline.CrmIniService [Thread-43] INFO
    // com.youdao.kids.crm.service.offline.CrmIniService iniLiveGoods:332 - iniLiveGoods
    // end--------1621240832928
    System.out.println(1621240832928L - 1621240764345L);
  }

  public int[] twoSum(int[] nums, int target) {

    Map<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<nums.length;i++){
      if(map.containsKey((target-nums[i]))){
        return new int[]{map.get(target-nums[i]),i};
      }else{
        map.put(nums[i],i);
      }
    }
    return null;
  }
}
