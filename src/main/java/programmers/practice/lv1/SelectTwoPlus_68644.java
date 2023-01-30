package programmers.practice.lv1;

import java.util.Set;
import java.util.TreeSet;

public class SelectTwoPlus_68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().mapToInt(i -> i).toArray();
    }
}
