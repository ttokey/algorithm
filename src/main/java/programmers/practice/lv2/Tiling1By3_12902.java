package programmers.practice.lv2;

public class Tiling1By3_12902 {
    public int solution(int n) {
        if (n % 2 != 0) {
            return 0;
        }
        long[] answer = new long[n + 1];
        answer[0] = 1;
        answer[2] = 3;
        answer[4] = 11;
        long sum = 1;
        for (int i = 6; i <= n; i += 2) {
            sum += answer[i - 4];
            answer[i] = (answer[i - 2] * answer[2] + sum * 2) % 1_000_000_007;
        }
        return (int) answer[n];
    }
}
