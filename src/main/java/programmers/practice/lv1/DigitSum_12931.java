package programmers.practice.lv1;

import java.util.Arrays;

public class DigitSum_12931 {
    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(s -> Integer.parseInt(s)).sum();
    }
}
