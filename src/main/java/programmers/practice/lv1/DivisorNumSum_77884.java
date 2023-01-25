package programmers.practice.lv1;

import java.util.stream.IntStream;

public class DivisorNumSum_77884 {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right).map(i -> i / (int) Math.sqrt(i) == Math.sqrt(i) ? -i : i).sum();
    }
}
