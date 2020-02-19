package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 正常来说 看   offer中day17 使用
 * @date:2020/2/16
 */
public class day17 {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if(list1 == null){
      return list2;
    }
    if(list2 == null){
      return list1;
    }
    if(list1.val<=list2.val){
      list1.next=mergeTwoLists(list1.next,list2);
      return list1;
    }else{
      list2.next=mergeTwoLists(list1,list2.next);
      return list2;
    }
  }
}
