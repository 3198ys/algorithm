package leetcode;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: leetcode
 * @date:2020/1/17
 */
public class DoubleList {

  private Node head,tail;
  private int size;
  public DoubleList(){
    head=new Node(0,0);
    tail=new Node(0,0);
    head.next=tail;
    tail.prev=head;
    size=0;
  }

  /**
   *  头部插入节点  双向链表的 这种插入  有虚拟头尾节点的   则 要注意就是该节点 的 的前后指针都要有所指向（这就是两步）   还有 他前后两个节点都要指向他 （这也是两步）这个操作
   *  同样适用于没有虚拟头为节点的 在中间插入的情形
   */

  public void addFirst(Node x){
    x.next=head.next;
    x.prev=head;
    head.next.prev=x;
    head.next=x;
    size++;
  }

  /**
   * 删除一个节点
   * @param x
   */
  public void remove(Node x){
    x.prev.next=x.next;
    x.next.prev=x.prev;
    size--;
  }

  /**
   * 删除最后一个节点并返回啊
   * @return
   */
  public Node removeList(){

    if(tail.prev==null){
      return null;
    }
    Node last=tail.prev;
    remove(last);
    return last;
  }

  public int size(){
    return size;
  }
  }
