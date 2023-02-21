package programmers.practice.lv1;

import java.util.HashSet;
import java.util.Set;

public class SumDivisor_12928 {
    public int solution(int n) {
        return getDivisorSum(n);
    }

    public int getDivisorSum(int n) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                result.add(i);
                result.add(n / i);
            }
        }
        return result.stream().mapToInt(i -> i).sum();
    }
}
