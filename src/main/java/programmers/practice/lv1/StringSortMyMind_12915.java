package programmers.practice.lv1;

import java.util.Arrays;

public class StringSortMyMind_12915 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> compare(a, b, n));
        return strings;
    }

    public int compare(String a, String b, int n) {
        int result = a.charAt(n) - b.charAt(n);
        if (result != 0) {
            return result;
        }
        return a.compareTo(b);
    }
}
