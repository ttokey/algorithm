package leetcode.easy;

import java.util.LinkedList;
import java.util.List;

//53. Maximum Subarray
/*
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> sumArray = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumArray.add(sum);
        }
        int maxIndex = 0;
        int minIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < sumArray.size(); i++) {
            if (maxSum < sumArray.get(i)) {
                maxSum = sumArray.get(i);
                maxIndex = i;
            }
        }
        for (int i = 0; i <= maxIndex; i++) {
            if (minSum > sumArray.get(i)) {
                minSum = sumArray.get(i);
                minIndex = i;
            }
        }
        if (minIndex == maxIndex) {
            return sumArray.get(maxIndex);
        }
        sumArray.add(0, 0);
        return sumArray.get(maxIndex + 1) - sumArray.get(minIndex);
    }
}   
