package programmers.practice.lv2;

public class LongJump_12914 {
    public long solution(int n) {
        long[][] combination = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    combination[i][j] = 1;
                } else {
                    combination[i][j] = (combination[i - 1][j - 1] + combination[i - 1][j]) % 1234567;
                }
            }
        }
        long result = 0;
        int c = 0;
        for (int i = n; i >= n / 2; i--) {
            if (i >= c) {
                result += combination[i][c];
            }
            c++;
        }
        return result % 1234567;
    }
}
