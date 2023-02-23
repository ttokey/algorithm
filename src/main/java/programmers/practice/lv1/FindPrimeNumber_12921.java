package programmers.practice.lv1;

public class FindPrimeNumber_12921 {
    public int solution(int n) {
        boolean[] arr = new boolean[n];
        arr[0] = true;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; i * j <= n; j++) {
                arr[i * j - 1] = true;
            }
        }
        int answer = 0;
        for (boolean b : arr) {
            if (!b) {
                answer++;
            }
        }
        return answer;
    }
}
