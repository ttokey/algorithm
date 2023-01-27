package programmers.practice.lv1;

import java.util.stream.IntStream;

public class DotProduct_70128 {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(i -> a[i] * b[i]).sum();
    }
}
