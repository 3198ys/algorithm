package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @date:2020/2/27
 */
public class day25 {
  public RandomListNode Clone(RandomListNode pHead)
  {

    if(pHead == null){
      return null;
    }

    //复制一个链表 在每个节点后面复制一个重复的节点
    RandomListNode currentNode=pHead;
    while (currentNode!=null){
      RandomListNode randomListNode = new RandomListNode(currentNode.label);
      RandomListNode next=currentNode.next;
      currentNode.next=randomListNode;
      randomListNode.next=next;
      currentNode=next;
    }

    //将复制好的节点 中被复制节点的random指针复制好
    RandomListNode ran=pHead;
    while (ran!=null){

      ran.next.random=ran.random==null?null:ran.random.next;
      ran=ran.next.next;
    }
    //分理出两个复制好的节点
    RandomListNode newNode=pHead.next;
    RandomListNode nowNode=pHead;
    while (nowNode!=null){
      RandomListNode currnetClone=nowNode.next;
      nowNode.next=currnetClone.next;
      currnetClone.next=currnetClone.next==null?null:currnetClone.next.next;
      nowNode=nowNode.next;
    }
    return newNode;
  }
}
