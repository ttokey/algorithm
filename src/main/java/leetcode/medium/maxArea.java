package leetcode.medium;

import java.util.Arrays;

public class maxArea {
    class Solution {
        public int maxArea(int[] height) {
            int water = 0;
            int[] sortHeight = Arrays.stream(height).sorted().toArray();
            int halfHeight = sortHeight[sortHeight.length - 2] / 2;
            int halfLength = height.length / 2;
            if (halfHeight > halfLength) {
                halfLength = 1;
            }
            int lowLength = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] != 0) {
                    lowLength = i;
                }
            }
            int highLength = height.length - 1;
            for (int i = height.length - 1; i >= 0; i--) {
                if (height[i] != 0) {
                    highLength = i;
                }
            }
            int maxLength = highLength - lowLength;
            int maxHeightIndex = sortHeight.length - 1;
            int maxHeight = sortHeight[maxHeightIndex];
            int secondHeight = sortHeight[maxHeightIndex - 1];
            for (int i = 0; i < height.length; i++) {
                if (height[i] == maxHeight) {
                    for (int j = 0; j < height.length; j++) {
                        if (height[j] == secondHeight) {
                            water = Math.max(water, (j - i) * Math.min(height[i], height[j]));
                        }
                    }
                }
                if (i == height.length - 1) {
                    maxHeightIndex--;
                    maxHeight = sortHeight[maxHeightIndex];
                    secondHeight = sortHeight[maxHeightIndex - 1];
                }
                if (secondHeight < maxLength) {
                    break;
                }
            }

            return water;
        }
    }
}
