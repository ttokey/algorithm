package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class CutNSquare_87390 {
    public int[] solution(int n, long left, long right) {
        List<Integer> result = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            result.add(getNum(i, n));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public int getNum(long input, long n) {
        return (int) Math.max(input / n, input % n) + 1;
    }
}
