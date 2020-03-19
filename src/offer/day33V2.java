package offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 看见有顺序的就要使用二分查找来做 这个就是 先用二分查找找到第一次 出现的 数字 之后用二分查找找到 最后一次出现的位置 之后 两个位置相减
 */
public class day33V2 {
    public static void main(String[] args) {
        int []a=new int[]{1,3,3,3,3,4,5};
        int i = GetNumberOfK(a, 2);
        System.out.println(i);
    }
    public static int GetNumberOfK(int [] array , int k) {

        if(array.length==0){
            return 0;
        }
        int firstIndex=firsetIndex(array,k);
        int lastIdnex=getLastIndex(array,k);
        if(firstIndex!=-1 && lastIdnex!=-1){

            return lastIdnex-firstIndex+1;
        }
        return 0;
    }

    public static int firsetIndex(int [] array , int k){
        int low=0;
        int height=array.length-1;
        int mid=0;
        while (low<=height){
            mid=(low+height)>>1;
            if(array[mid]<k){
                low=mid+1;
            }else if(array[mid]>k){
                height=mid-1;
            }else if(mid-1>=0&&array[mid-1]==k){
                height=mid-1;
            }else{
                return mid;
            }
        }
        return -1;

            }

            public static int getLastIndex(int [] array,int k){

        int low=0;
        int height=array.length-1;
        int mid=0;
        while (low<=height){
            mid=(low+height)>>1;
            if(array[mid]<k){
                low=mid+1;
            }else if(array[mid]>k){
                height=mid-1;
            }else if(mid+1<array.length && array[mid+1]==k){
                low=mid+1;
            }else {
                return mid;
            }

        }
        return -1;
            }
}
