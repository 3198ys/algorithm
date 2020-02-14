package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个链表，反转链表后，输出新链表的表头
 * @date:2020/2/14
 */
public class day16 {

  public ListNode ReverseList(ListNode head) {

    if(head == null || head.next==null){
      return head;
    }
    ListNode next=head.next;
    ListNode resultNode=ReverseList(head.next);
    next.next=head;
    head.next=null;
    return  resultNode;
  }
  public ListNode ReverseListV2(ListNode head) {
    ListNode pre=null;
    ListNode next=null;
    while (head!=null){
      next=head.next;
      head.next=pre;
      pre=head;
      head=next;
    }
    return next;
  }

}
