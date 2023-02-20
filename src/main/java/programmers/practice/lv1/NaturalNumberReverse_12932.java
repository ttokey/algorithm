package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.List;

public class NaturalNumberReverse_12932 {
    public int[] solution(long n) {
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            result.add((int) (n % 10));
            n /= 10;
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
