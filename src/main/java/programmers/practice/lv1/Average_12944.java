package programmers.practice.lv1;

import java.util.Arrays;

public class Average_12944 {
    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }
}
