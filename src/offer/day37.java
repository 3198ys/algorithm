package offer;

import java.util.ArrayList;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 利用双指针来做  使用全排列一般都是不重复的数组之类的
 * @date:2020/3/25
 */
public class day37 {
  public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

    ArrayList<ArrayList<Integer>> list=new ArrayList<>();
    int left=1;int right=2;
    while (left<right){

      ArrayList<Integer> tmqList=new ArrayList<>();
       int tmqSum=(left+right)*(right-left+1)/2;
       if(tmqSum==sum){
         for(int i=left;i<=right;i++){
           tmqList.add(i);
         }
         list.add(tmqList);
         left++;
       }else if(tmqSum>sum){
         left++;
       }else{
         right++;
       }
    }
    return list;
  }


}
