package programmers.practice.lv1;

import java.util.stream.LongStream;

public class SumOfBetweenTwoNumber_12912 {
    public long solution(int a, int b) {
        return LongStream.rangeClosed(a > b ? b : a, a > b ? a : b).sum();
    }
}
