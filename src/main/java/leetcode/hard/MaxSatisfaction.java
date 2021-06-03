//https://leetcode.com/problems/reducing-dishes/

package leetcode.hard;

import java.util.Arrays;

public class MaxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        int[] sortedSatisFaction = Arrays.stream(satisfaction).sorted().toArray();
        int result = 0;
        for (int i = 0; i < sortedSatisFaction.length; i++) {
            int k = 1;
            int sum = 0;
            for (int j = i; j < sortedSatisFaction.length; j++) {
                sum += sortedSatisFaction[j] * k;
                k++;
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

}
