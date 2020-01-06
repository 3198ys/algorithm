package offer;

public class day03 {
    private static int partion(int [] arr,int startIndex,int endIndex){
        int pivot=arr[startIndex];
        int left=startIndex;
        int right=endIndex;
        while (left<right){
            while (left<right&&arr[right]>=pivot){
                right--;
            }
            while (left<right&& arr[left]<=pivot){
                left++;
            }
            if(left<right){
                int p=arr[right];
                arr[right]=arr[left];
                arr[left]=p;
            }
        }
        arr[startIndex]=arr[left];
        arr[left]=pivot;
        return left;
    }

    public static void quickSort(int [] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int partions=partion(arr,startIndex,endIndex);
        quickSort(arr,startIndex,partions-1);
        quickSort(arr,partions+1,endIndex);
    }

    public static int partionsv2(int [] arr,int startIndex,int endIndex){
        int a=arr[startIndex];
        int mark=startIndex;
        for(int i=startIndex+1;i<=endIndex;i++){
            if(arr[i]<a){
                mark++;
                int p=arr[i];
                arr[i]=arr[mark];
                arr[mark]=p;
            }
        }
        arr[startIndex]=arr[mark];
        arr[mark]=a;
        return mark;
    }
}
