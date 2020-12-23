package leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author ys 2020/12/23
 *
 * @description 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *     <p>注意:
 *     <p>可以认为区间的终点总是大于它的起点。 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
此题解题思路使用贪心算法懒做 将二维数组的end进行升序排序 之后 遍历这个二维数组 如果 start大于这个最小的end 则不会有交叉的数组 则可以+1
 */
public class ques435 {
  public int eraseOverlapIntervals(int[][] intervals) {

if(intervals.length == 0){return 0;}
    //按end进行升序操作
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[1]-o2[1];
      }
    });
 int length=intervals.length;

    int count=1;
    int minEnd=intervals[0][1];
    for(int[] a:intervals){
      if(a[0]>=minEnd){
        count++;
        minEnd=a[1];
      }
    }
    return length-count;
  }
}
