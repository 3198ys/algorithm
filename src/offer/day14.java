package offer;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 正确的思想 使用冒泡排序来做
 * @date:2020/2/11
 */
public class day14 {

  public static void main(String[] args) {
    int [] arr=new int[]{10,13,2,67,1,34,4,11,12};
    partion(arr,0,arr.length-1);
    for(int a:arr){
      System.out.println(a);
    }
  }
  public void reOrderArray(int [] array) {

   for(int i=0;i<array.length;i++){
     for(int j=0;j<array.length-1-i;j++){
       if(array[j]%2==0 && array[j+1]%2==1){
         int tmq=array[j];
         array[j]=array[j+1];
         array[j+1]=tmq;
       }
     }
   }
  }

  /**
   * 这个只能保证奇数在前 偶数在后不能保证 他原始的顺序
   * @param array
   * @param start
   * @param end
   */
  public static void partion(int [] array,int start,int end){
    int temp=array[start];
    int left=start;
    int right=end;
    while (left<right){
      while (left<right && (array[right]&1)==0){
        right--;
      }
      while (left<right && (array[left]&1)==1){
        left++;
      }
      if(left<right){
        int tmq=array[left];
        array[left]=array[right];
        array[right]=tmq;
      }
    }

  }
}
