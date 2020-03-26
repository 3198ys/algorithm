package jichu;

/**
 * 归并排序
 */
public class guibing {
    public static void main(String[] args) {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergetsort(a, 0, a.length-1);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }


    public static void merge(int []a,int left,int mid,int right){
        int [] tmq=new int[a.length];
        int p1=left;int p2=mid+1;int k=left;

        while (p1<=mid && p2<=right){
            if(a[p1]<=a[p2]){
                tmq[k++]=a[p1++];
            }else{
                tmq[k++]=a[p2++];
            }
        }
        while (p1<=mid){
            tmq[k++]=a[p1++];
        }
        while (p2<=right){
            tmq[k++]=a[p2++];
        }
        for(int i=left;i<=right;i++){
            a[i]=tmq[i];
        }
    }

    public static void mergetsort(int []a,int start,int end){
        if(start<end){
            int mid=(start+end)>>1;
            mergetsort(a,start,mid);
            mergetsort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }
}
