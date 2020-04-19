package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 *
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 * 题解使用的是  优先队列来做  可以自己实现堆 也可以使用java 自带的 priorityQueue
 *
 * 先对开始时间进行排序 之后 使用结束时间进入优先队列  优先队列最小的 在第一位 如果新入的 开始时间 小于 当前的 第一位的结束时间则入队 相当于开课一个房间 否则将第一位与当前的 时间互换
 */
public class day253 {

    public static void main(String[] args) {
        int [][]a =new int[][]{{6,15},{13,20},{6,17}};
        int i = minMeetingRooms(a);
        System.out.println(i);
    }
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return integer-t1;
            }
        });

        for(int i=0;i<intervals.length;i++){
            if(queue.peek()==null){
                queue.add(intervals[i][intervals[0].length-1]);
            }else if(queue.peek()<=intervals[i][0]){
                queue.poll();
                queue.add(intervals[i][intervals[0].length-1]);
            }else{
                queue.add(intervals[i][intervals[0].length-1]);
            }
        }

return queue.size();
    }
}
