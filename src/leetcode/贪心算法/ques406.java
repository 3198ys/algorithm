package leetcode.贪心算法;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @Author ys 2020/12/30
 *
 * @description 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为
 *     hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *     <p>请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j
 *     个人的属性（queue[0] 是排在队列前面的人）。
 *     一般这种贪心算法都是通过对二维数组进行排序  这道题就是第一个元素降序 第二个元素升序排序
 */
public class ques406 {

  public int[][] reconstructQueue(int[][] people) {

    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if(o1[0]==o2[0]){
          return o1[1]-o2[1];
        }else{
          return o2[0]-o1[0];
        }
      }
    });

    LinkedList<int[]> aa=new LinkedList<>();
    for(int[] ar:people){

      aa.add(ar[1],ar);
    }
    return aa.toArray(new int[aa.size()][]);
  }
}
