package offer;

import java.util.ArrayList;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * @date:2020-01-07
 */
public class day04 {

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

    ArrayList<Integer> list=new ArrayList<>();
    if(listNode==null){
      return list;
    }
    digui(list,listNode);
    return list;
  }

  public void digui(ArrayList<Integer> list,ListNode listNode){
    if(listNode==null){
      return;
    }
    digui(list,listNode.next);
    list.add(listNode.val);

  }
}
