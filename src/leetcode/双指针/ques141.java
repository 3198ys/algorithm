package leetcode.双指针;



/**
 * @Author ys 2020/7/21
 *
 * @description 给定一个链表，判断链表中是否有环。
 *     <p>为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环
 *     <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle
 *     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ques141 {
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode first = head.next;
    while (first != null && first.next != null) {
      if (slow == first) {
        return true;
      }
      slow = slow.next;
      first = first.next.next;
    }

    return false;
  }


  //判断是否有环 快慢指针就行了  快指针走两步 慢指针走一步 这样最后一定
  public  boolean hasCycleV2(ListNode head){
    if(head == null){
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next !=null){
      if(slow == fast){
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }
}
