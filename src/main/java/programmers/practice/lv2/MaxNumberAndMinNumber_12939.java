package programmers.practice.lv2;

import java.util.Arrays;

public class MaxNumberAndMinNumber_12939 {
    public String solution(String s) {
        int[] intArr = Arrays.stream(s.split(" ")).mapToInt(str -> Integer.parseInt(str)).toArray();
        Arrays.sort(intArr);
        return intArr[0] + " " + intArr[intArr.length - 1];
    }
}
