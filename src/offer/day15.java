package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 理由双指针来做  让其中一个链表先去移动   他要比后面那个变链表快  k-1就可以了  这样 当 第一个链表到达终点的时候 后一个节点正好是倒数第k哥
 * @date:2020/2/13
 */
public class day15 {

  public ListNode FindKthToTail(ListNode head,int k) {

    if(head == null){
      return null;
    }
    ListNode tmq=head;

    int i=0;
    while (tmq!=null){
      if(i>=k){

        //当i等于k的时候就开始移动这样的话   前面那个节点已经移动了 比他多移动了k-1各节点
        head=head.next;
      }
      tmq=tmq.next;
      i++;
    }
    return i<k?null:head;
  }

  //这道题主要就是用双指针来做就行了 先让第一个指针先走 当他走到第k步的时候再让第二个指针也开始走，这样 第一个指针走完的时候，第二个指针正好倒数第k个，
  //而且需要注意的就是就是需要把当前的连表给另外一个赋值方便指针走

  public ListNode findKthodV2(ListNode listNode,int target){
    if(listNode == null){
      return null;
    }
    ListNode tmq = listNode; //第一个指针先走的
    int i=0;//用于记录的步数用的
    while (tmq!=null){
      if(i>=target){
        //如果第一个指针已经走过了目标步数 现在第二个指针就需要走了
        listNode=listNode.next;
      }
      i++;
      tmq=tmq.next;
    }
    return i<target?null:listNode;
  }
}
