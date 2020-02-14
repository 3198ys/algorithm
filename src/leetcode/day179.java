package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 这道题使用了一个自定义排序来做
 * @date:2020/2/14
 */
public class day179 {

  private class zidingyisoirt implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
      String order1=o1+o2;
      String order2=o2+o1;
      return order1.compareTo(order2);
    }
  }


  public String largestNumber(int[] nums) {
    String [] targerts=new String[nums.length];
    for(int i=0;i<nums.length;i++){
      targerts[i]=String.valueOf(nums[i]);
    }
    Arrays.sort(targerts,new zidingyisoirt());
    if(targerts[0].equals("0")){
      return "0";
    }
    StringBuffer sb=new StringBuffer();
    for(String a:targerts){
      sb.append(a);
    }
    return sb.toString();
  }
}
