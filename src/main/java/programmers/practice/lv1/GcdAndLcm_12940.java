package programmers.practice.lv1;

public class GcdAndLcm_12940 {
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int[] answer = {gcd, n * m / gcd};
        return answer;
    }

    public int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
