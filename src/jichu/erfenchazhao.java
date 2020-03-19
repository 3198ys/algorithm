package jichu;

public class erfenchazhao {

    public static void main(String[] args) {
        int a[]=new int[]{2,4,6,8,9,210,234};
        int i = binSearchDigui(8, a,0,a.length-1);
        System.out.println(i);
    }
    public static int binSerarch(int key,int [] array){

        int low=0;
        int heigh=array.length-1;
        int mid=0;
        while (low<=heigh){
            mid=(low+heigh)>>1;
            if(array[mid]==key){
                return array[mid];
            }else if(array[mid]<key){
                low=mid+1;
            }else{
                heigh=mid-1;
            }
        }
        return -1;
    }

    public static int binSearchDigui(int key,int [] array,int low,int height){

        int mid=(low+height)>>1;
        if(array[mid]>key){
            return binSearchDigui(key,array,low,mid-1);
        }else if(array[mid]<key){
            return binSearchDigui(key, array, mid+1,height );
        }else{
            return array[mid];
        }
    }
}
