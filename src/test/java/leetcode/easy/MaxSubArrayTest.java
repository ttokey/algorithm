package leetcode.easy;

import org.junit.jupiter.api.Test;

class MaxSubArrayTest {
    MaxSubArray maxSubArray = new MaxSubArray();

    @Test
    public void test() {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        int result = maxSubArray.maxSubArray(nums);
        System.out.println(result);

    }
}