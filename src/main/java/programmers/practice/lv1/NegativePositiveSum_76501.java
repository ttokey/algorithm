package programmers.practice.lv1;

import java.util.stream.IntStream;

public class NegativePositiveSum_76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length).map(i -> signs[i] ? absolutes[i] : -absolutes[i]).sum();
    }
}
