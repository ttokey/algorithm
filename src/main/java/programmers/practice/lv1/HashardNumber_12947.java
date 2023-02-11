package programmers.practice.lv1;

import java.util.Arrays;

public class HashardNumber_12947 {
    public boolean solution(int x) {
        return x % Arrays.stream(String.valueOf(x).split("")).mapToInt(s -> Integer.parseInt(s)).sum() == 0;
    }
}
