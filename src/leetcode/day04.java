package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: leetcode
 * @date:2020/1/13
 */
public class day04 {

  public static void main(String[] args) {
    int [] nums1=new int[]{1,3};
    int [] nums2=new int[]{2};
    int medianSortedArrays = findMedianSortedArrays(nums1, nums2);
    System.out.println(medianSortedArrays);
  }
  public static int  findMedianSortedArrays(int[] nums1, int[] nums2) {

    int numsLength= nums1.length;
    int numsLength2=nums2.length;
    int i=0;
    int j=0;
   List<Integer> list=new ArrayList<>();
    while (i<=numsLength-1&&j<=numsLength2-1){
      if(nums1[i]<=nums2[j]){
        list.add(nums1[i++]);
      }else{
        list.add(nums2[j++]);
      }
    }
    if(i<=numsLength-1){
      for(;i<=numsLength-1;i++){
        list.add(nums1[i]);
      }
    }

    if(j<=numsLength2-1){
      for(;j<=numsLength2-1;j++){
        list.add(nums2[j]);
      }
    }
    int middle=-1;
    if(list.size()%2==0){
      middle=(list.size()+1)/2;
      return (list.get(middle)+list.get(middle+1))/2;
    }else{
      middle=(list.size())/2;
      return list.get(middle);
    }




  }
}
