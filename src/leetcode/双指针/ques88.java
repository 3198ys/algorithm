package leetcode.双指针;

/**
 * @Author ys 2020/7/20
 * @description
 */
public class ques88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index=m-1; int index2=n-1;
    int index3=m+n-1;
    while (index>=0 || index2>=0){
      if(index<0){
        nums1[index3--]=nums2[index2--];
      }else if(index2<0){
        nums1[index3--]=nums1[index--];
      }else if(nums1[index]>=nums2[index2]){
        nums1[index3--]=nums1[index--];
      }else{
        nums1[index3--]=nums2[index2--];
      }
    }
  }
}
