package leetcode;

/**
 * @Author ys 2021/5/11
 *
 * @description 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *     <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
 *     nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3
 *     处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *     <p>给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。


 这道题就是利用二分查找到方式来做，因为 他不是一个正常的升序 所以 二分选择中间位置的时候需要知道他在 数据段中哪一个位置
 */
public class daday3 {

  public int search(int[] nums, int target) {

    if(nums == null|| nums.length==0){
      return -1;
    }
    int left=0;
    int right=nums.length-1;
    int lenght=nums.length;
    while (left<=right){
      int middle=(left+right)/2;
      if(nums[middle] ==target){
        return middle;
      }
      if(nums[0]<=nums[middle]){
        //说明他的中间节点在斗转过来的数组上
        if(nums[0]<=target && target<=nums[middle]){
          right=middle-1;
        }else{
          left=middle+1;
        }
      }else{
        //说明他的中间节点在不是倒转的数据段上
        if(nums[middle]<=target && target<=nums[lenght-1]){
          left=middle+1;
        }else{
          right=middle-1;
        }
      }
    }
    return -1;
  }
}
