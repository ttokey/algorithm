package leetcode.medium;

import java.util.Arrays;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int[] sorted = Arrays.stream(nums)
                .sorted()
                .toArray();


        return sorted[sorted.length - k];
    }
}
