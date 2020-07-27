package leetcode.排序;

/**
 * @Author ys 2020/7/27
 * @description 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class ques215 {
  public int findKthLargest(int[] nums, int k) {

    for(int i=k/2;i>=0;i--){
      createHead(nums,i,k-1);
    }

    for(int i=k;i<nums.length;i++){
      if(nums[0]<=nums[i]){
        nums[0]=nums[i];
        createHead(nums,0,k-1);
      }
    }
    return nums[0];
  }

  private void createHead(int [] arr,int pos,int length){
    int tmq=arr[pos];
    int child=2*pos+1;
    while (child<=length){
      if(child+1<=length && arr[child]>arr[child+1]){
        child++;
      }
      if(tmq<=arr[child]){
        break;
      }
      arr[pos]=arr[child];
      pos=child;
      child=2*pos+1;
    }
    arr[pos]=tmq;
  }
}
