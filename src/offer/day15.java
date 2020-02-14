package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 理由双指针来做  让其中一个链表先去移动   他要比后面那个变链表快  k-1就可以了  这样 当 第一个链表到达终点的时候 后一个节点正好是倒数第k哥
 * @date:2020/2/13
 */
public class day15 {

  public ListNode FindKthToTail(ListNode head,int k) {

    if(head == null){
      return null;
    }
    ListNode tmq=head;

    int i=0;
    while (tmq!=null){
      if(i>=k){

        //当i等于k的时候就开始移动这样的话   前面那个节点已经移动了 比他多移动了k-1各节点
        head=head.next;
      }
      tmq=tmq.next;
      i++;
    }
    return i<k?null:head;
  }
}
