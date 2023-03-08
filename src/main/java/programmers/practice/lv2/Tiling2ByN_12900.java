package programmers.practice.lv2;

public class Tiling2ByN_12900 {
    public int solution(int n) {
        long[] answer = new long[n + 1];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i <= n; i++) {
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1_000_000_007;
        }
        return (int) answer[n];
    }
}
