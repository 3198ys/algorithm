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



  //合并两个数组，到第一个数组中从后面后面开始一点点找 如果合并不是第一个数组更加容易
  public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
    int index = m-1;
    int index2 = n-1;
    int index3= m+n-1;
    while(index >=0 || index2>=0){
      if(index <0){
        //说明第一个数组已经遍历完了，那么直接把第二个数组的元素放到第一个数组的末尾即可
        nums1[index3--]= nums2[index2--];
      }else if(index2 <0){
        nums1[index3--] = nums1[index--];
      }else if(nums1[index]>=nums2[index2]){
        nums1[index3--] = nums1[index--];
      }else{
        nums1[index3--] = nums2[index2--];
      }
    }
  }
}
