package leetcode;

import java.util.List;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 *
 *
 * 这道题的结题思路就是利用   归并排序  正常的归并排序  对于数组来说 就是 一直 找中间的 不断的进行拆分 最后拆成一个个单独的数字在地柜回来组装排序  二链表的拆分就用快慢指针就可以了
 * 找到中间的 链表
 */
public class day148 {

    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode mide=getMid(head);
        ListNode second=mide.next;
        mide.next=null;//这样就分成了两个链表了
        ListNode left = sortList(head);
        ListNode right = sortList(second);

        return merge(left,right);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode(0);
        ListNode tmq=listNode;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                tmq.next=l1;
                l1=l1.next;
            }else{
                tmq.next=l2;
                l2=l2.next;
            }
            tmq=tmq.next;

        }
        if(l1!=null){
            tmq.next=l1;
        }else{
            tmq.next=l2;
        }
        return listNode.next;
    }
    public ListNode getMid(ListNode node){

        if(node == null){
            return node;
        }
        ListNode slow=node;
        ListNode first=node;
        while (first!=null && first.next!=null){
            slow=slow.next;
            first=first.next.next;
        }
        return slow;
    }
}
