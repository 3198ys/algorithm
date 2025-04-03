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

  //本道题主要就是哪一个递归把连表里的数据都放在数组里面然后返回 递归 一定你要有返回的条件才行 否则就会一直递归下去
  public void digui2(ArrayList<Integer> list,ListNode listNode){
    //递归一定要有返回值
    if(listNode == null){
      return;
    }
    digui2(list,listNode.next);
    list.add(listNode.val);
  }

  public ArrayList<Integer> shoujilist(ArrayList<Integer> list,ListNode listNode){
    if(listNode==null){
      return list;
    }
    digui(list,listNode);
    return list;
  }
}
