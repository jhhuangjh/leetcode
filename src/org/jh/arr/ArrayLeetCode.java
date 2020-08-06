package org.jh.arr;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/8/2 17:32
 */
public class ArrayLeetCode {

    /**
     * @param nums nums = [1,2,3,4]
     * @return [1,3,6,10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
     */
    public static int[] runningSum(int[] nums) {
        int[] sums = new int[0];
        if (nums != null && nums.length > 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 0; i < nums.length -1 ; i++) {
                sums[i + 1] = nums[i + 1] + sums[i];
            }
        }
        return sums;
    }

}
