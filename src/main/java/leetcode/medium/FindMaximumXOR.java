/*
421. Maximum XOR of Two Numbers in an Array
Share
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Example 1:
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.

Example 2:
Input: nums = [0]
Output: 0

Example 3:
Input: nums = [2,4]
Output: 6

Example 4:
Input: nums = [8,10,2]
Output: 10

Example 5:
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 */


package leetcode.medium;


public class FindMaximumXOR {

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int leftCursor = 0;
        int rightCursor = nums.length - 1;
        max = Math.max(max, sumXOR(nums[leftCursor], nums[rightCursor]));

        while (leftCursor < rightCursor) {
            int ifLeft = sumXOR(nums[leftCursor + 1], nums[rightCursor]);
            int ifRight = sumXOR(nums[leftCursor], nums[rightCursor - 1]);
            max = Math.max(max, Math.max(ifLeft, ifRight));
            if (ifLeft < ifRight) {
                leftCursor++;
            } else {
                rightCursor--;
            }
        }

//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                max = Math.max(max, sumXOR(nums[i], nums[j]));
//            }
//        }
        return max;
    }

    public int sumXOR(int a, int b) {
        int result = 0;
        int maxLength = Math.max(getLength(a), getLength(b));
        for (int i = 0; i < maxLength; i++) {
            if ((a & 1) != (b & 1)) {
                result += (1 << i);
            }
            a = a >> 1;
            b = b >> 1;
        }
        return result;
    }

    public int getLength(int input) {
        int count = 0;
        while (input > 0) {
            input = input >> 1;
            count++;
        }
        return count;
    }


}
