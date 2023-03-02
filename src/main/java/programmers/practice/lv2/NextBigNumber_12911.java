package programmers.practice.lv2;

public class NextBigNumber_12911 {
    public int solution(int n) {
        int nCount = countOne(n);
        int nextCount = 0;
        while (nCount != nextCount) {
            n++;
            nextCount = countOne(n);
        }
        return n;
    }

    public int countOne(int n) {
        int result = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }
}
