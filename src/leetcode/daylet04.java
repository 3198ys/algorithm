package leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 *
 * i+j=(m+n)/2 当 m+n是奇数的时候   i+j=(m+n+1)/2

 */
public class daylet04 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {

            findMedianSortedArrays(nums2,nums1);
        }

        int iMin=0;int iMax=m;

        while (iMin<=iMax){
            int i=(iMin+iMax)/2;
            int j=(m+n+1)/2-i;
            /**
             * 正常max(nums1[i-1],nums2[j-1])<=min(nums1[i],nums2[j])
             *
             * 因为数组是递增的 所以 nums1[i-1]<nums1[i]  nums2[j-2]<nums2[j]
             *
             * 当 nums1[j-1]>nums2[i] i就要增加
             * nums2[i-1]>nums2[j]  i 就要减少
             */
            if( j!=0 && i!=m && nums2[j-1]>nums1[i]){
               iMin=i+1;
            }else if(i!=0 && j!=n && nums1[i-1]>nums2[j]){
                iMax=i-1;
            }else{
                //此时 就是符合规矩的这时候就可以直接求  中位数了但是  要注意  i==0 和j==0de情况 和 i==m 或者 j==n的情况

                int maxLeft=0;
                if(i==0){
                    maxLeft=nums2[j-1];
                }else if(j==0){
                    maxLeft=nums1[i-1];
                }else{
                    maxLeft=Math.max(nums1[i-1],nums2[j-1]);
                }
                if((m+n)%2==1){

                    /**
                     * 如果是奇数 直接 返回左面的 不用考虑右边
                     */
                    return maxLeft;
                }


                int maxright=0;
                if(i==m){
                    maxright=nums2[j];
                }else if(j==n){
                    maxright=nums1[i];
                }else{
                    maxright=Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+maxright)/2.0;
            }
        }
        return 0.0;

    }
}
