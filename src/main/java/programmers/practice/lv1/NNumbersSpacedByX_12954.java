package programmers.practice.lv1;

import java.util.stream.LongStream;

public class NNumbersSpacedByX_12954 {
    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, (long) n).map(i -> x * i).toArray();
    }
}
