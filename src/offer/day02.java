package offer;

import java.util.ArrayList;

public class day02 {

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
