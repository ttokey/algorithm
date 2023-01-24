package programmers.practice.lv1;

import java.util.Arrays;

public class PlusMissingNumber_86051 {
    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }
}
