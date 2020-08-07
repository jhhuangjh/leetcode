package org.jh.arr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hjh
 * @version 1.0
 * @date 2020/8/2 17:32
 */
public class ArrayLeetCode {

    /**
     * @param nums nums = [1,2,3,4]
     * @return [1, 3, 6, 10]
     * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4]
     */
    public static int[] runningSum(int[] nums) {
        int[] sums = new int[0];
        if (nums != null && nums.length > 0) {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                sums[i + 1] = nums[i + 1] + sums[i];
            }
        }
        return sums;
    }

    /**
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，
     * 此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     *
     * @param candies      candies = [2,3,5,1,3]
     * @param extraCandies extraCandies = 3
     * @return [true, true, true, false, true]
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNum = 0;
        List<Boolean> resultList = new ArrayList<>();
        for (int candy : candies) {
            maxNum = Math.max(maxNum, candy);
        }
        for (int candy : candies) {
            resultList.add(candy + extraCandies >= maxNum);
        }
        return resultList;
    }

}
