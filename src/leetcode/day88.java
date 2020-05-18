package leetcode;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *

 */
public class day88 {

    /**
     * 第一种做法 复制一个新的数组出来
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums_copy=new int[m];
        System.arraycopy(nums1,0,nums_copy,0,m);
        int p1=0;int p2=0;int p=0;
        while (p1<m && p2<n){
            nums1[p++]=nums_copy[p1]<nums2[p2]?nums_copy[p1++]:nums2[p2++];
        }
        if(p1<m){
            System.arraycopy(nums_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if(p2<m){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }



    }

    /**
     * 使用 不需要 复制数组直接 从后往前复制就可以了
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeV2(int[] nums1, int m, int[] nums2, int n){

        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;
        while (p1>=0 && p2>=0){
            nums1[p--]=nums1[p1]>nums2[p2]?nums1[p1--]:nums2[p2--];
        }
        /**
         * 这里 肯定是  如果 nums2有剩余的话 那肯定就是都比nums1中的小,吧nums2 都复制到nums1 的前面去
         */
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }

}
