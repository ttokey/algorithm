package leetcode.easy;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = 1; i * j < n; j++) {
                    isPrime[i * j] = true;
                }
            }
        }
        return count;
    }
}
