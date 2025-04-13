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
    return pre;
  }

  //翻转连表就用迭代法是你最推荐的
  public ListNode reverse(ListNode current){

    ListNode pre= null;//需要一个前置节点 因为 需要每次把当前节点指向前面 所以需要这个节点
    while (current != null){
      ListNode tmq=current.next;//将他的下一个节点赋值给临时节点 这种是赋值操作 不是将当前节点指向下一个节点 一定要注意这个
      current.next=pre;//将当前节点指向前一个节点
      pre= current;//将当前节点估值给前一个节点，这样就是后一个节点指向前一个节点了
      current = tmq;//将原来的下一个节点赋值给当前节点
    }
    return pre;
  }


}
