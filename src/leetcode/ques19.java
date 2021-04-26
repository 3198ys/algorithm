package leetcode;

/**
 * @Author ys 2021/4/25
 *
 * @description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *     <p>进阶：你能尝试使用一趟扫描实现吗？
 */
public class ques19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode targetHead=new ListNode(0,head);
    int index=0;
    ListNode tmq=head;
    ListNode slow=targetHead;

    for(int i=0;i<n;i++){
      tmq=tmq.next;
    }
    //当快指针已经与慢指针相差n个节点的时候，上面那个循环 因为满指针是 一个前面的虚拟节点所以 快指针走多少步就相差多少个节点
    while (tmq!=null){
      tmq=tmq.next;
      slow=slow.next;
    }
    //如果快指针已经到了末尾的空指针 二者还相差n个节点  a-->b-->c---d--->null a是慢指针 快指针在 null上相差3个 删除倒数第三个就是b正好是慢指针的下一位
    // 即使 整个链表长度就是n 则 快指针 在null的时候满指针是没动的 下面的代码也是可以的 因为slow 就是targetHead slow.next=slow.next.next; 就已经把原来的头节点删掉了 所以targetHead.next就是原头节点的下一位
    slow.next=slow.next.next;

    return targetHead.next;
  }
}
