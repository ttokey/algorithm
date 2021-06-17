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


import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR {
    // binary trie, where each trie node has only 2 child
    // one child will represent bit "1" in the binary representation of num
    // one child will represent bit "0" in the binary representation of num
    private static class TrieNode {
        // children[0]: represent bit "1" in the binary representation
        // children[1]: represent bit "0" in the binary representation
        private final TrieNode[] children;

        private TrieNode() {
            children = new TrieNode[2];
        }
    }

    private TrieNode root;

    public int findMaximumXOR(int[] nums) {
        // initialize the root node
        root = new TrieNode();
        TrieNode curr;

        // build the trie
        for (int num : nums) {
            // starting from root;
            curr = root;

            // since every num is positive, their 31th bit is always 0
            // we can ignore that bit and directy build from the 30th bit
            for (int i = 30; i >= 0; --i) {
                int bit = getIthBit(num, i);

                // if current bit is 0, it will go to children[1]
                // if current bit is 1, it will go to children[0]
                if (curr.children[bit ^ 1] == null) {
                    curr.children[bit ^ 1] = new TrieNode();
                }

                curr = curr.children[bit ^ 1];
            }
        }

        int ans = Integer.MIN_VALUE;

        // iterate through each num again
        // starting from those significant bits of num, we try the best
        // to go to the node that represent the negation of current bit
        // if such node doesn't exist, we have to go the node that represents
        // the current bit
        for (int num : nums) {
            // starting from root
            curr = root;

            // keep track of the maximum result of XOR current num with
            // other num in the array
            int rst = 0;
            for (int i = 30; i >= 0; --i) {
                int bit = getIthBit(num, i);

                // check to see if node that represents the negation of
                // current bit exists or not. If exists, go to that way

                // if current bit is 1, then we want to go to children[1] (which represents 0)
                // if current bit is 0, then we want to go to children[0] (which represents 1)
                if (curr.children[bit] != null) {
                    curr = curr.children[bit];

                    // if exists, then we will have a "1" at the current index
                    // in the result of maximum XOR
                    rst += (1 << i);
                }
                // if not exists
                else {
                    curr = curr.children[bit ^ 1];
                }
            }

            // keep track of global maximum
            ans = Math.max(ans, rst);
            // there is no need to continue when final result has reached max value
            if (ans == Integer.MAX_VALUE) {
                break;
            }
        }

        return ans;
    }

    // get the ith bit (count from LSB, 0-based) of num
    private int getIthBit(int num, int i) {
        return (num & (1 << i)) == 0 ? 0 : 1;
    }


    public int findMaximumXOR3(int[] nums) {

        int xorMax = 0, bitMask = 0;
        for (int i = 31; i >= 0; i--) {
            if (i == 5) {
                int k = 1;
            }
            bitMask = bitMask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & bitMask);
            }
            int temp = xorMax | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    xorMax = temp;
                    break;
                }
            }
        }
        return xorMax;
    }


    public int findMaximumXOR2(int[] nums) {
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
