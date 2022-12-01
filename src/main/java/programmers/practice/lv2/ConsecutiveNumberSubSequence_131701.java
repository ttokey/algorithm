package programmers.practice.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConsecutiveNumberSubSequence_131701 {
    public int solution(int[] elements) {
        Set<Integer> sequenceSubSet = new HashSet<>();
        int totalSum = Arrays.stream(elements).sum();
        for (int i = 0; i < elements.length; i++) {
            for (int j = 1; j <= elements.length / 2 + 1; j++) {
                int sum = 0;
                for (int k = i; k < i + j; k++) {
                    int index = k % elements.length;
                    sum += elements[index];
                    sequenceSubSet.add(sum);
                    sequenceSubSet.add(totalSum - sum);
                }
            }
        }
        return sequenceSubSet.size() + 1;
    }
}
