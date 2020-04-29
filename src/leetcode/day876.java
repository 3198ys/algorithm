package leetcode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 *0 1 2 3 4 5
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 * 使用快慢指针 来最  快指针一次 走两步 慢指针一次走一步
 */
public class day876 {
    /**
     * 但指针也是对的
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        if(head==null){
            return head;
        }
        int i=0;
        ListNode tmq=head;
        while (tmq!=null){
            i++;
            tmq=tmq.next;
        }
        System.out.println(i);
//        if(i%2==0){
//            i=i/2;
//        }else{
//            i=i/2;
//        }
        int j=0;
        System.out.println(i);
        while (j!=i/2){
            head=head.next;
            j++;
        }

        return head;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode middleNodeV2(ListNode head) {

        ListNode node=head;
        ListNode tmq=head.next;
        while (tmq!=null && tmq.next!=null){
            node=node.next;
            tmq=tmq.next.next;
        }
        return node;
    }

}
