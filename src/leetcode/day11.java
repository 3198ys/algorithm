package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 反转一个单链表。 有两种实现方式一种是 通过  递归 来实现  另一种是通过  循环来实现
 * @date:2020/2/4
 */
public class day11 {

  //d递归来做  主要就是 后面的节点只想前一个节点   前一个节点指向空   返回最后一个节点
  public ListNode reverseList(ListNode head) {


    if(head == null || head.next == null){
      return head;
    }

    ListNode tmp=head.next;
    ListNode resultNode=reverseList(head.next);
    tmp.next=head;
    head.next=null;
    return resultNode;


  }

  public ListNode aa(ListNode head){
    if(head == null || head.next==null){
      return head;
    }
    ListNode tmq=head.next;
    ListNode resultNode=aa(head.next);
    tmq.next=head;
    head.next=null;
    return resultNode;
  }

  /**
   * 使用循环来做
   * @param head
   * @return
   */
  public ListNode reverseListV2(ListNode head) {
    ListNode pre=null;
    ListNode next=null;
    while (head!=null){
      next=head.next;
      head.next=pre;
      pre=head;
      head=next;
    }
    return pre;
  }


}
