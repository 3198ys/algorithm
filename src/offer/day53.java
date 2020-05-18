package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @date:2020/5/10
 */
public class day53 {

  public ListNode EntryNodeOfLoop(ListNode pHead)
  {

    if(pHead==null){
      return null;
    }
    ListNode slow=pHead;
    ListNode fast=pHead;
    while(fast!=null && fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
      if(slow==fast){
        slow=pHead;
        while (slow!=fast){
          slow=slow.next;
          fast=fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
