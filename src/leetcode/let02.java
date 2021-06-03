package leetcode;

/**
 * @Author ys 2021/6/1
 *
 * @description 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *     <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
 *     <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
  这道题 整体思路其实我是对的 但是唯一有问题地方就是 找到l1 node和 l2 node 当前值的时候 他是使用了  或 为循环条件 当其中一个链表到头的时候就变成了 0 继续执行下去
 第二个关键点就是 就是 目标链表定义了两个 一个head用于返回的 另一个用户往下走的tail
 */
public class let02 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head=null;
    ListNode tail=null;
    int carry=0;
    while (l1 !=null || l2 !=null){
      int l1Value=l1!=null?l1.val:0;
      int l2Value=l2!=null?l2.val:0;
      int sum=(l1Value+l2Value+carry)%10;
      carry=(l1Value+l2Value+carry)/10;
      if(head == null){
        head=tail=new ListNode(sum);
      }else{
        tail.next=new ListNode(sum);
        tail=tail.next;
      }
      if(l1!=null){
        l1=l1.next;
      }
      if(l2!=null){
        l2=l2.next;
      }
    }
    if(carry>0){
      tail.next=new ListNode(carry);
    }
    return head;
  }
}
