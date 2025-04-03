package offer;

/**
 * 快排
 */
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

    //快拍的思想就是首先讲第一个元素当做基准元素然后让数组中的小于基准元素的都在他左边，大于基准元素的都在他的右边
    public static int partionv3(int arr[],int startIndex,int endIndex){
        int partion= arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while(left <right){
            //首先找到 右边小于基准元素的位置
            while(left<right && partion<= right){
                right -- ;
            }
            while (left<right &&partion>= left){
                left++;
            }
            if(left<right){
                int p=arr[right];
                arr[right]=arr[left];
                arr[left]=p;
            }
        }
        //把left的值放在最嘴边
        arr[startIndex]=arr[left];
        arr[left]=partion;//partion 放在left的地方
        return left;
    }

    public static void quickSortv3(int arr[],int startIndex,int endIndex){
        if(arr == null || arr.length ==0){
            return ;
        }
        int partion= partionv3(arr,startIndex,endIndex);
        quickSortv3(arr,0,partion-1);
        quickSortv3(arr,partion+1,endIndex);
    }
}
