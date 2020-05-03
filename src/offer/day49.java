package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 一个数组变成奇数偶数相间隔
 * @date:2020/4/26
 */
public class day49 {

  public static void main(String[] args) {
    int[] nums = {0, 0, 0, 1, 1, 1, 1, 1, 1};
    nums = sort(nums);
    for (int a : nums) {
      System.out.println(a);
    }
  }

  public static int[] sort(int[] nums) {
    int left = 0;
    int right = 1;
    while (left < nums.length && right < nums.length) {
      if (nums[left] % 2 == 0 && nums[right] % 2 != 0) {
        left += 2;
        right += 2;
      } else if (nums[left] % 2 != 0 && nums[right] % 2 != 0) {
        right += 2;
      } else if (nums[left] % 2 == 0 && nums[right] % 2 == 0) {
        left += 2;
      } else {
        int tmq = nums[left];
        nums[left] = nums[right];
        nums[right] = tmq;
      }
    }
    return nums;
  }
}
