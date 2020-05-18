package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: offer
 * @date:2020/5/18
 */
public class day80 {



  class Node{
    Node pre;
    Node next;
    int val;
    public Node(int val){
      this.val=val;
    }
  }
  class DoubleList{
    Node head;
    Node last;
    int size;

    public void insertFirst(int val){
      Node tmq=head;
      Node node=new Node(val);
      if(tmq==null){
        last=node;
      }else{
        node.next=tmq;
        tmq.pre=node;
      }
      head=node;
      size++;
    }

    public void deleteLast(){
      Node tmq=last;
      if(tmq==null){
        return;
      }else{
        Node pre=last.pre;
        last=pre;
        pre.next=null;
        tmq.pre=null;
        size--;
      }
    }
    public void delete(Node node){
      Node preNode=node.pre;
      Node lastNode=node.next;
      preNode.next=lastNode;
      lastNode.pre=preNode;
      node.pre=null;
      node.next=null;
    }
    public int getSize(){
      return size;
    }
  }
  class LRU{
    Map<String,Node> map=new HashMap<>();
    DoubleList  list;
    int len;
    public LRU(int len){
      this.len=len;
    }
    public void add(String key,int val){
      if(map.containsKey(key)){
        Node tmq=map.get(key);
       Node newNode= new Node(val);
        map.put(key,newNode);
        list.delete(tmq);
        list.insertFirst(val);
      }else{
        if(len==list.getSize()){
          map.remove(key);
          list.deleteLast();
          Node newNode=new Node(val);
          map.put(key,newNode);
          list.insertFirst(val);
        }else{
          map.put(key,new Node(val));
          list.insertFirst(val);
          len++;
        }
      }
    }
  }

}
