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


    public static ListNode sortv2(ListNode root){
        if(root == null || root.next == null){
            return root;
        }
        //接下来的主要思路就是从头到尾的的循环找出当前节点应该在的位置
        ListNode curr=root.next; // 需要比较的节点
        ListNode pre = root;//前一个节点
        ListNode listNode = new ListNode(-1); //后续为了方便遍历整个连表的节点
        listNode.next = root;
        while (curr !=null){
            if(curr.val<pre.val){
                //如果当前节点小于前一个节点的话就需要去调整位置，主要的调整方式就是首先去要在连表上把当前节点去掉，然后在链表中循环找到改节点应该在的位置
                pre.next = curr.next;
                ListNode node1=listNode;
                ListNode node2 = listNode.next;
                while (curr.val>node2.val){
                    //如果当前节点大于node2的节点就要一直向下遍历，为了找到 curr<node2的然后插入node2之前
                    node1=node2;
                    node2=node2.next;
                }
                //如果跳出了循环说明现在 curr已经小于了node2但是大于了node1现在就可以插入了
                node1.next = curr;
                curr.next = node2;
                //现在就需要将当前节点向下移动一位了
                curr = pre.next;
            }else{
                //如果当前节点已经大于pre节点那么现在就需要一次向下了
                pre = curr;
                curr= curr.next;
            }
        }
        return listNode.next;
    }
}
