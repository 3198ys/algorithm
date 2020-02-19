package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: offer
 * @date:2020/2/16
 */
public class day17 {

  public ListNode Merge(ListNode list1,ListNode list2) {

    if(list1 ==null){
      return list2;
    }
    if(list2 == null){
      return list1;
    }
    if(list1 == null && list2 == null){
      return null;
    }
    ListNode result1=new ListNode(0);
    /**
     * 重点是这个地方  一定要找一个别的  节点去循环 如果不的话  最后返回的 就已经不是头结点了
     */
    ListNode result=result1;
    while (list1!=null && list2!=null){
      if(list1.val<=list2.val){
        result.next=new ListNode(list1.val);
        list1=list1.next;
      }else{
        result.next=new ListNode(list2.val);
        list2=list2.next;
      }
      result=result.next;
    }
    if(list1!=null){
      result.next=list1;
    }
    if(list2!=null){
      result.next=list2;
    }
    return result1.next;
  }
}
