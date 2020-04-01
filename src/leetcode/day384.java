package leetcode;

import java.util.Random;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
这道题主要就是洗牌算法   如果不用洗牌算法的话 就是自己要有一个list 每次用随机数从这里面取出一个并且 将取出移除

洗牌算法实际上就是 将 元素和他后面随机的一个元素进行 互换 只要保证 被换出去的元素不会取出就可以了

 * @date:2020/3/31
 */
public class day384 {

  int [] array;
  int [] oriange;

  Random random=new Random();
  public day384(int[] nums) {

    array=nums;
    oriange=nums.clone();
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {

    array=oriange;
    oriange=oriange.clone();
    return oriange;
  }


  public void swap(int a,int b){
    int tmq=array[a];
    array[a]=array[b];
    array[b]=tmq;
  }
  /** Returns a random shuffling of the array. */
  public int[] shuffle() {

    for(int i=0;i<array.length;i++){
      swap(i,range(i,array.length));
    }
    return array;
  }

  public int range(int min,int max){
    return random.nextInt(max-min)+min;
    //这个获取的就是从min到 max之间的随机数
  }

  /**
   * Your Solution object will be instantiated and called as such:
   * Solution obj = new Solution(nums);
   * int[] param_1 = obj.reset();
   * int[] param_2 = obj.shuffle();
   */
}
