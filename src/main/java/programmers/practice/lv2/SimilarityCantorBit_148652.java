package programmers.practice.lv2;

public class SimilarityCantorBit_148652 {
    public int solution(int n, long l, long r) {
        Long.toString(5, 3);
        return (int) dp(n, --l, --r);
    }

    public long dp(int n, long l, long r) {
        if (n == 1) {
            int[] result = {1, 1, 0, 1, 1};
            int count = 0;
            for (long i = l; i <= r; i++) {
                if (result[(int) i] == 1) {
                    count++;
                }
            }
            return count;
        }
        long unit = (long) Math.pow(5, n - 1);

        if (l >= 2 * unit && l < 3 * unit && r >= 2 * unit && r < 3 * unit) {
            return 0;
        }
        if (l >= 3 * unit) {
            l -= unit;
        } else if (l >= 2 * unit) {
            l = 2 * unit;
        }
        if (r >= 3 * unit) {
            r -= unit;
        } else if (r >= 2 * unit) {
            r = 2 * unit - 1;
        }

        long leftUnit = l / unit;
        long rightUnit = r / unit;

        if (leftUnit == rightUnit) {
            return dp(n - 1, l - leftUnit * unit, r - rightUnit * unit);
        }
        return dp(n - 1, l - leftUnit * unit, unit - 1) + dp(n - 1, 0, r - rightUnit * unit) + (long) Math.pow(4, n - 1) * (rightUnit - leftUnit - 1);
    }
}
