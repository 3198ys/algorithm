package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: o输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * 这道题的主要思路就是  公共节点之后的链表是完全相同的这样的话 要先使两个链表的 长度相同 在同时向下走  找到相同的 节点 这样相同节点后面的节点就都是相同的了 所有相同的节点一定是在短的链表上
 * 另一种解法  使用hashMap存放一个链表的的所有节点在遍历另一个节点
 * @date:2020/3/16
 */
public class day32 {

  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

    ListNode tmq1=pHead1;
    ListNode tmq2=pHead2;

    int len1=getlen(tmq1);
    int len2=getlen(tmq2);
    if(len1>len2){
      pHead1=getResultListNode(pHead1,len1-len2);
    }else{
      pHead2=getResultListNode(pHead2,len2-len1);
    }
    while (pHead1!=null){
      if(pHead1==pHead2){
        return pHead1;
      }
      pHead1=pHead1.next;
      pHead2=pHead2.next;
    }
    return null;
  }

  int getlen(ListNode pHead1){

    int sum=0;
    while (pHead1!=null){
      pHead1= pHead1.next;
      sum++;
    }
    return sum;
  }
  ListNode getResultListNode(ListNode node,int a){
    while (a>0){
      node=node.next;
      a--;
    }
    return node;
  }
}
