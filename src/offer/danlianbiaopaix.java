package offer;

/**
 * 单链表排序
 * https://blog.csdn.net/liewen_/article/details/82926619?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 *
 */
public class danlianbiaopaix{


    /**
     * 插入排序
     * @param head
     * @return
     */
    public static ListNode sort(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        ListNode aux=new ListNode(0);
        aux.next=head;
        while (cur!=null){
            if(cur.val<pre.val){
                //现在去掉 cur 然后去给他找一个新的位置
                pre.next=cur.next;
                ListNode node1=aux;
                ListNode node2=aux.next;
                while (cur.val>node2.val){
                    node1=node2;
                    node2=node2.next;
                }
                node1.next=cur;
                cur.next=node2;
                cur=pre.next;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return aux.next;
    }
}
