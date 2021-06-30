package jichu;

/**
 * @author: create by ys
 * @version: v1.0
 * @description: jichu
 * @date:2020/2/8
 */
public class quickSort {


  public static void main(String[] args) {
    int [] arr=new int[]{10,13,2,67,1,34,4,11,12};
    sort(arr,0,arr.length-1);
    for(int a:arr){
      System.out.println(a);
    }
  }

  /**
   * 第一种写法
   * @param arr
   * @param start
   * @param end
   * @return
   */
  public static int partition(int [] arr,int start,int end){
    int target=arr[start];
    while (start<end){
      while (start<end && target<=arr[end]){
        end--;
      }
      if(start<end){
        int tmq=arr[start];
        arr[start]=arr[end];
        arr[end]=tmq;
      }
      while (start<end && target>=arr[start]){
        start++;
      }
      if(start<end){
        int tmq=arr[start];
        arr[start]=arr[end];
        arr[end]=tmq;
      }
    }
    return start;
  }

  private static int partitionV2(int[] arr, int start,int end){
    int pivotKey=arr[start];
    while(start<end){
      while(start<end && arr[end]>=pivotKey)
        end--;
      swap(arr,start,end);
      while(start<end && arr[start]<=pivotKey)
        start++;
      swap(arr,start,end);
    }
    return start;
  }

  /**
   * 最正确的写发
   * @param arr
   * @param start
   * @param end
   * @return
   */
  private static int partitionV3(int [] arr,int start,int end){
    int target=arr[start];
    int left=start;
    int right=end;
    while (left<right){
      while (left<right && target<=arr[right]){
        right--;
      }
      while (left<right && target>=arr[left]){
        left++;
      }
      if(left<right){
        int tmq=arr[left];
        arr[left]=arr[right];
        arr[right]=tmq;
      }
    }
    arr[start]=arr[left];
    arr[left]=target;
    return left;
  }

  /**
   * 单循环的快排
   * @param arr
   * @param start
   * @param end
   * @return
   */
  private static int partitionV4(int [] arr,int start,int end){
    int target=arr[start];
    int mark=start;

    /**
     * 使用了一个mark指针 然后当有一个位置上的数字比目标数字小的时候mark就向右移动一位 之后与其互换位置
     * 这样就可以保证在mark左面的都是比目标值小的了
     */
    for(int i=start+1;i<=end;i++){
      if(arr[i]<target){
        mark++;
        int tmq=arr[mark];
        arr[mark]=arr[i];
        arr[i]=tmq;
      }
    }
    arr[start]=arr[mark];
    arr[mark]=target;
    return mark;
  }

  private static void swap(int[] arr, int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }

  public int partitionys(int[] array,int start,int end){
    int target=array[start];
    int left=start;
    int rihgt=end;
    while (left<rihgt){
      while (left<rihgt && target<=array[rihgt]){
        rihgt--;
      }
      while (left<rihgt && target>=array[left]){

        left++;
      }
      if(left<rihgt){
        int tmq=array[left];
        array[left]=array[rihgt];
        array[rihgt]=tmq;
      }
    }
    array[start]=array[left];
    array[left]=target;
    return left;

  }

  public void sortys(int [] num,int left,int right){
    int partition=partitionys(num,left,right);
    sortys(num,left,partition-1);
    sortys(num,partition+1,right);
  }
  public static void sort(int [] arr,int start,int end){
    if(start>=end){
      return;
    }
    int partition = partitionV4(arr, start, end);
    sort(arr,start,partition-1);
    sort(arr,partition+1,end);
  }

}
