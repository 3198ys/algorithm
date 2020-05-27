package offer;

/**
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author: create by ys
 * @version: v1.0
 * @description: offer
 * @date:2020/1/13
 */
public class day06 {


  //最普通的 一次循环
  public int minNumberInRotateArrayV2(int [] array) {

    if(array.length==0){
      return 0;
    }
    for(int i=0;i<array.length;i++){
      if(array[i]>array[i+1]){
        return array[i+1];
      }
    }
    return 0;
  }

  //别的方法 二分查找来做
  public int minNumberInRotateArray(int [] array) {
    if(array.length==0){
      return 0;
    }
    int left=0;
    int right=array.length-1;
    int middle=-1;
    //正常的二分查找是通过  left和right来判断需不需要循环的 这个比较特殊 使用值来进行二分查找
    while (array[left]>=array[right]){
      if(right-left==1){
        middle=right;
        break;
      }
      middle=left+(right-left)/2;
      if(array[left]<=array[middle]){
        left=middle;
      }
      if(array[middle]<=array[right]){
        right=middle;
      }
    }
    return array[middle];

  }

  //普通二分法
  int bsearchWithoutRecursion(int a[], int key) {
    int low = 0;
    int high = a.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (a[mid] > key)
        high = mid - 1;
      else if (a[mid] < key)
        low = mid + 1;
      else
        return mid;
    }
    return -1;
  }


  public int minNumberInRotateArrayV3(int[] array){
    int left=0;
    int right=array.length-1;
    int mid=0;
    while (array[left]>=array[right]){
      if(right-left==1){
        mid=right;
        break;
      }

      mid=(left+right)/2;
      if(array[left] == array[right] && array[right] == array[left]){
        return getNums(array,left,right);
      }
      if(array[mid]>=array[left]){
        left=mid;
      }
      if(array[mid]<=array[right]){
        right=mid;
      }
    }
    return array[mid];
  }

  public int getNums(int[] array,int left,int right){
    int tmq=array[left];
    for(int i=left+1;i<right;++i){

      if(tmq>array[i]){
        tmq=array[i];
      }
    }
    return tmq;
  }
}
