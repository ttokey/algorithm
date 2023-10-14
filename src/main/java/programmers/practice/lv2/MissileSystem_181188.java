package programmers.practice.lv2;

import java.util.Arrays;

public class MissileSystem_181188 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        int answer = 1;
        int start = targets[0][0];
        int end = targets[0][1];
        for (int[] target : targets) {
            if (target[0] >= end) {
                start = target[0];
                end = target[1];
                answer++;
            } else {
                start = Math.max(start, target[0]);
                end = Math.min(end, target[1]);
            }
        }
        return answer;
    }
}
