package offer;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 *
 * 这道题的结题思路就是利用优先队列来做，使用两个 优先队列来做 偶数的时候 插入大顶堆 并且吧大顶堆上面的  根节点给 小丁对 奇数的时候 插入小丁对之后从小丁对 根节点给大顶堆
 * 这样 最后  小丁对的所有数都大于 大顶堆了  二者的 根节点一定是 中位数 的选择 如果是偶数  二者求平均值 如果是 奇数 就从小丁对中找
 *
 *
 *
 * 第二种解法 利用插入排序来做 实际上就是在 插入的时候就怕数据的顺序排列好就可以了
 * @date:2020/6/2
 */
public class day61 {

    private PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    private PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer >((x,y)->y-x);

    int count=0;
    public void Insert(Integer num) {

        if(count%2==0){
            maxHeap.offer(num);
            Integer poll = maxHeap.poll();
            minHeap.offer(poll);
        }else {
            minHeap.offer(num);
            Integer poll = minHeap.poll();
            maxHeap.offer(poll);
        }
        count++;
    }

    public Double GetMedian() {

        if(count%2==0){

            return new Double(minHeap.peek() + maxHeap.peek())/2;
        }else{
            return Double.valueOf(minHeap.peek());
        }

    }


    /**
     * 俩面是使用 插入排序做的
     * @param num
     */

    private LinkedList<Integer> list=new LinkedList<>();
    public void InsertV2(Integer num) {

        if(list.size()==0 || num<list.getFirst()){
            list.addFirst(num);
        }else{

            boolean insertFlag=false;
            for (Integer e: list) {
                if(num<e){
                    int i = list.indexOf(e);
                    list.add(i,num);
                    insertFlag=true;
                    break;
                }
            }
            if(!insertFlag){
                list.addLast(num);
            }
        }

    }
    public Double GetMedianV2() {

        if(list.size()==0){
            return null;
        }
        if(list.size()%2==0){
            int i=list.size()/2;
            return Double.valueOf(list.get(i)+list.get(i-1))/2;
        }else{
            return Double.valueOf(list.get((list.size()-1)/2));
         }

    }

    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2,11);
        System.out.println(list.indexOf(3));
    }
}
