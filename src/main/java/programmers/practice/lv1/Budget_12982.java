package programmers.practice.lv1;

import java.util.Arrays;

public class Budget_12982 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for (int i = 0; i < d.length && budget >= d[i]; i++) {
            budget -= d[i];
            answer++;
        }
        return answer;
    }
}
