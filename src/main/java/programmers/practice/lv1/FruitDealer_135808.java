package programmers.practice.lv1;

import java.util.Arrays;
import java.util.Collections;

public class FruitDealer_135808 {
    public int solution(int k, int m, int[] score) {
        Integer[] scores = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scores, Collections.reverseOrder());
        int answer = 0;
        for (int i = 1; i * m - 1 < score.length; i++) {
            answer += scores[i * m - 1] * m;
        }
        return answer;
    }
}
