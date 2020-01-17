package leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *题解   实现 lru可以有很多中方法  第一种 就是使用 hashMap和双向链表来做，用hashMap主要是为了查找方便 可以很快的 就查找到key，而使用双向链表则是因为再删除操作的时候需要操作被删除节点的前面节点，
 * 单项链表只给一个节点是不能删除吊的
 * 具体的实现  先实现 一个双向链表   双向链表的  增加头结点，删除节点 删除尾节点  2 获取操作就是 在判断一个key是否存在 如果存在  则 将改节点放到双向链表的最前面  插入操作  如果 改key已经存在则删除原来的链表
 * 中的节点   将其插入到到双向链表的最前面   如果 已经查过了双向链表的最大容量 则删除双向链表的最后节点  和hashmap中的key
 * 之后 将 该节点插入到 hashmap中喝 和插入到双向链表最前面
 *
 *
 * 使用  linkedList来做 不用自己实现 双向链表
 * @date:2020/1/17
 */
public class LRUCache1 {

  private int cap;

  HashMap<Integer,Integer> map;
  private LinkedList list;
  public LRUCache1(int capacity) {

    map=new HashMap<>();
    list=new LinkedList();
    cap=capacity;
  }

  /**
   * 获取操作 如果存在这个key  这将这个key放到 双向链表的最前面 没有返回-1
   *
   * @param key
   * @return
   */
  public int get(int key) {

    if(!map.containsKey(key)){
      return -1;
    }
    Object o = list.get(key);
    put(key,val);
    return val;
  }

  /**
   *插入的时候  如果 存在删除原来的双向链表查到 最前面  如果超过最大的容量 则删除双向链表的最后一个，将这个查到双向链表最前面
   * @param key
   * @param value
   */
  public void put(int key, int value) {

    Node x=new Node(key,value);
    if(map.containsKey(key)){
      list.remove(x);
      list.addFirst(x);
    }else{
      if(cap==list.size()){
        list.removeList();
      }
      list.addFirst(x);
      map.put(key,x);
    }
  }
}
