package leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JPopupMenu;

/**
 * @Author ys 2020/12/28
 * @description
 */
public class ques452 {
//  public static int findMinArrowShotsV2(int[][] points) {
//
//    if(points.length == 0 || points == null){
//      return 0;
//    }
//    //因为有负数存在所以不能用这种方案
//    Arrays.sort(points, new Comparator<int[]>() {
//      @Override
//      public int compare(int[] o1, int[] o2) {
//        return o1[1]-o2[1];
//      }
//    });
//    int index=1;
//    int min=points[0][1];
//    for(int [] a:points){
//      if(a[0]>min){
//        min=a[1];
//        index++;
//      }
//    }
//    return index;
//  }

  public static void main(String[] args) {
    int [][]a=new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
    int minArrowShots = findMinArrowShots(a);
    System.out.println(minArrowShots);
  }

  public static int findMinArrowShots(int[][] points) {
    if (points.length == 0) {
      return 0;
    }
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] point1, int[] point2) {
        if (point1[1] > point2[1]) {
          return 1;
        } else if (point1[1] < point2[1]) {
          return -1;
        } else {
          return 0;
        }
      }
    });
    int pos = points[0][1];
    int ans = 1;
    for (int[] balloon: points) {
      if (balloon[0] > pos) {
        pos = balloon[1];
        ++ans;
      }
    }
    return ans;
  }

}
