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

    public void merge(int[] nums1, int m, int[] nums2, int n) {


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j<m && nums2[i]<=nums1[j]){
                    nums1[j+1]=nums1[j];
                }
            }
        }
    }
}
