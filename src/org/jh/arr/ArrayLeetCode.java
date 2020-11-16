package org.jh.arr;

import java.util.*;

import static java.lang.Math.*;

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

    /**
     * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
     * 返回好数对的数目。
     *
     * @param nums nums = [1,2,3,1,1,3]
     * @return 4 有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
     * @date 2020/08/09
     */
    public int numIdenticalPairs(int[] nums) {
        /*int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result++;
                }
            }
        }
        return result;*/

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            result += value * (value - 1) / 2;
        }
        return result;
    }

    /**
     * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
     * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
     *
     * @param nums nums = [2,5,1,3,4,7],
     * @param n    n = 3
     * @return [2, 3, 5, 4, 1, 7]
     */
    public int[] shuffle(int[] nums, int n) {
        if (n == 1) {
            return nums;
        }
        int[] result = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            /*if (i % 2 == 0) {
                result[i] = nums[j++];
            } else {
                result[i] = nums[n++];
            }*/
            // 双指针
            result[j++] = nums[i];
            result[j++] = nums[n + i];
        }
        return result;
    }

    /**
     * 给你一个以行程长度编码压缩的整数列表 nums 
     * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），
     * 每一对都表示解压后子列表中有 freq 个值为 val 的元素，
     * 你需要从左到右连接所有子列表以生成解压后的列表。
     * 请你返回解压后的列表。
     * 第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
     * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
     * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]
     *
     * @param nums nums = [1,2,3,4]
     * @return [2, 4, 4, 4]
     * @date 2020/08/12
     */
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        // 遍历得到新数组的长度
        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }
        int[] result = new int[len];
        for (int i = 0, index = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                result[index++] = nums[i + 1];
            }
        }
        return result;
    }

    /**
     * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
     * 目标数组 target 最初为空。
     * 按从左到右的顺序依次读取 nums[i] 和 index[i]，
     * 在 target 数组中的下标 index[i] 处插入值 nums[i] 。
     * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
     *
     * @param nums  nums = [0,1,2,3,4]
     * @param index index = [0,1,2,2,1]
     * @return [0, 4, 1, 3, 2]
     * @date 2020/08/15
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                index[j] += index[j] >= index[i] ? 1 : 0;
            }
        }
        for (int i = 0; i < n; i++) {
            target[index[i]] = nums[i];
        }
        return target;
    }

    /**
     * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
     * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，
     * 其中 j 满足 j != i 且 nums[j] < nums[i] 。
     * 2 <= nums.length <= 500
     * 0 <= nums[i] <= 100
     * 解题思路
     * 桶排序思想，先在桶中计算元素的数量，再遍历桶，计算当前元素的前面所有元素的数量，并将结果赋值给当前元素。
     * 这样桶中就记录了比当前元素小的所有数字的数目，再遍历原数组将桶中对应的值取出放入数组并返回。
     *
     * @param nums nums = [8,1,2,2,3]
     * @return [4, 0, 1, 1, 3]
     * @date 2020.08.16
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        /*int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i] > nums[j] && i != j)
                    result[i]++;
            }
        }
        return result;*/
        // 索引对应数值
        int[] temp = new int[101];
        for (int num : nums) {
            temp[num]++;
        }
        // 从前面开始累加
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                result[i] = temp[nums[i] - 1];
            }
        }
        return result;
    }

    /**
     * 1295. 统计位数为偶数的数字
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     *
     * @param nums nums = [12,345,2,6,7896]
     * @return 2
     * @date 2020.08.17
     */
    public int findNumbers(int[] nums) {
        /*int count = 0;
        for (int value : nums) {
            int num = value;
            //记录除10的次数
            int countTen = 0;
            while (num != 0) {
                num /= 10;
                countTen++;
            }
            //如果除10的次数是偶数次，则该数为偶数位数
            if (count % 2 == 0) {
                count++;
            }
        }
        return count;*/
        int count = 0;
        for (int num : nums) {
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                ++count;
            }
        }
        return count;
    }

    /**
     * 1266. 访问所有点的最小时间
     * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
     * 你可以按照下面的规则在平面上移动：
     * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
     * 必须按照数组中出现的顺序来访问这些点。
     *
     * @param points points = [[1,1],[3,4],[-1,0]]
     * @return 7
     * @date 2020.08.20
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        int len = points.length;
        for (int i = 0; i < len - 1; ++i) {
            result += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
        }
        return result;
    }

    /**
     * 1464. 数组中两元素的最大乘积
     * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，
     * 使 (nums[i]-1)*(nums[j]-1) 取得最大值。
     * 请你计算并返回该式的最大值。
     * 2 <= nums.length <= 500
     * 1 <= nums[i] <= 10^3
     *
     * @param nums nums = [3,4,5,2]
     * @return 12
     * @date 2020.08.04
     * [10,2,5,2]
     */
    public int maxProduct(int[] nums) {
        int x = 0, y = 0;
        for (int num : nums) {
            if (num > x) {
                y = x;
                x = num;
            } else if (num > y) {
                y = num;
            }
        }
        return (x - 1) * (y - 1);
    }

    /**
     * 1450. 在既定时间做作业的学生人数
     * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。
     * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。
     * 请返回在查询时间 queryTime 时正在做作业的学生人数。
     * 形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。
     *
     * @param startTime startTime = [1,2,3]
     * @param endTime   endTime = [3,2,7]
     * @param queryTime endTime = [3,2,7]
     * @return 1
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int resultNum = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] > queryTime || endTime[i] < queryTime) continue;
            resultNum++;
        }
        return resultNum;
    }

    /**
     * 面试题 17.10. 主要元素
     * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
     *
     * @param nums [1,2,5,9,5,9,5,5,5] [3,2]
     * @return 5 -1
     */
    public int majorityElement(int[] nums) {
        /*HashMap<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > (nums.length / 2)) return num;
        }
        return -1;*/
        // 首先找到这个数组中出现最多的元素。
        int cur = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cur == nums[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                cur = nums[i];
                count = 1;
            }
        }
        // 遍历一遍结果就是找到出现次数最多的元素，判断是不是满足题目中大于一半的条件。
        int curNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == cur) {
                curNum++;
            }
        }
        if (curNum > nums.length / 2) {
            return cur;
        }
        return -1;
    }
}
