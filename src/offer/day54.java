package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @date:2020/5/10
 */
public class day54 {

  /**
   * 链表去重
   * @param pHead
   * @return
   */
  public ListNode deleteDuplication(ListNode pHead)
  {
    ListNode node = pHead;
    if(pHead == null || pHead.next == null){
      return pHead;
    }
    while(node.next != null){
      if(node.next.val == node.val)
        node.next = node.next.next;
      else
        node = node.next;
    }
    return pHead;
  }

  /**
   * 直接删除重复节点  这里是虚拟一个头结点
   * @param pHead
   * @return
   */
  public ListNode deleteDuplicationV2(ListNode pHead)
  {

    ListNode head=new ListNode(0);
    head.next=pHead;
    ListNode pre=head;
    ListNode last=head.next;
    while (last!=null){
      if(last.next!=null && last.val==last.next.val){
        while (last.next!=null && last.val==last.next.val){
          last=last.next;
        }
        pre.next=last.next;
        last=last.next;
      }else{
        pre=pre.next;
        last=last.next;
      }
    }
    return head.next;
  }
}

