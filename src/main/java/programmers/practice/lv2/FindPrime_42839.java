package programmers.practice.lv2;

import java.util.HashSet;
import java.util.Set;

public class FindPrime_42839 {
    boolean[] used;
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int count = 0;
        used = new boolean[numbers.length()];
        dfs(numbers, 0, new StringBuilder());
        for (int number : numberSet) {
            if (isPrime(number)) {
                count++;
            }
        }
        return count;
    }

    public void dfs(String numbers, int size, StringBuilder sb) {
        if (sb.length() > 0) {
            numberSet.add(Integer.parseInt(sb.toString()));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(numbers.charAt(i));
                dfs(numbers, size + 1, sb);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public boolean isPrime(int input) {
        if (input <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }
}
