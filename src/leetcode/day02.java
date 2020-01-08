package leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class day02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode curr=new ListNode(0);
        ListNode p1=l1;ListNode p2=l2;
        ListNode result=curr;
        int carry=0;
        while (p1!=null || p2!=null){
            int x=p1!=null?p1.val:0;
            int y=p2!=null?p2.val:0;
            int sum=carry+x+y;
            carry=sum/10;
            result.next=new ListNode(sum%10);
            result=result.next;
            if(p1!=null){
                p1=p1.next;
            }
            if(p2!=null){
                p2=p2.next;
            }
        }
        if(carry>0){
            result.next=new ListNode(carry);
        }
        return curr.next;
    }
}
