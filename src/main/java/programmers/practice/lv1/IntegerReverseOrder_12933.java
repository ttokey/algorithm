package programmers.practice.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class IntegerReverseOrder_12933 {
    public long solution(long n) {
        return Long.parseLong(Arrays.stream(String.valueOf(n).split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining()));
    }
}
