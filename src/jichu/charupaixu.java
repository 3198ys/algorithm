package jichu;

public class charupaixu {
    public static void main(String[] args) {

    }

    public void sort(int[] a){
        for(int i=0;i<a.length;i++){
            int temp=a[i];
            int j;
            for( j=i;j>0&a[j-1]>temp;j--){
                a[j]=a[j-1];
            }
            a[j]=temp;
        }
    }
}
