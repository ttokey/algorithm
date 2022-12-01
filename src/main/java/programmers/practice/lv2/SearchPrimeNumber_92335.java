package programmers.practice.lv2;

import java.util.Arrays;

public class SearchPrimeNumber_92335 {
    public int solution(int n, int k) {
        String arithmeticNumber = Integer.toString(n, k);
        long[] withoutZeroList = getWithoutZero(arithmeticNumber);
        int answer = 0;
        for (long input : withoutZeroList) {
            if (isPrime(input)) {
                answer++;
            }
        }
        return answer;
    }

    public long[] getWithoutZero(String input) {
        return Arrays.stream(input.split("0+")).mapToLong(s -> Long.valueOf(s)).toArray();
    }

    public boolean isPrime(long input) {
        if (input < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}
