package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * 这道题巧妙的地方就是通过count的计数器来找到数组中最多的数字
 * @date:2020/3/1
 */
public class day27 {
  public int MoreThanHalfNum_Solution(int [] array) {

    int count=0;
    int target=0;
    for(int i=0;i<array.length;i++){
      if(count==0){
        target=array[i];
      }
      if(target!=array[i]){
        count--;
      }else {
        count++;
      }
    }
    int index=0;
    //上面出来的情况就是  target一定就是数组里面最多的那个数字
    for(int i=0;i<array.length;i++){
      if(target==array[i]){
        index++;
      }
    }
    if(index*2>array.length){
      return target;
    }else{
      return -1;
    }
  }
}
