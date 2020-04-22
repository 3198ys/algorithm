package leetcode;

/**
 * 给定一个有序的数组但是有重复 的比入[112233456677] 找出所有不重复的数字的个数并且 在该数组上修改将不重复的数组放到前面
 *
 *
 * 使用快慢指针来做
 */
public class day1000 {

    public int getSort(int [] nums){

        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            /**
             * 如果快指针和满指针所对应的值相同的时候就要移动 快指针 去找不同的 放到慢指针上
             */
            if(nums[slow]!=nums[fast]){

                slow++;
                nums[slow]=nums[fast];

            }
        }
        return slow+1;
    }
}
