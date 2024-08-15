package leetcode.hard._719;

import java.util.Arrays;

public class Find_Kth_Smallest_Pair_Distance {
    public int smallestDistancePair(int[] nums, int k) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        int min = 0;
        int max = sortedNums[sortedNums.length - 1];
        int mid = (min + max) / 2;

        while (min < max) {
            int count = getCount(sortedNums, mid);
            if (count < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
            mid = (min + max) / 2;
        }
        return mid;
    }

    public int getCount(int[] sortedNums, int mid) {
        int count = 0;
        for (int i = 0; i < sortedNums.length - 1; i++) {
            int j = sortedNums.length - 1;
            while (i < j && sortedNums[j] - sortedNums[i] > mid) {
                j--;
            }
            count += j - i;
        }
        return count;
    }
}
