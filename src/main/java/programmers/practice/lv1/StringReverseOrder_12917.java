package programmers.practice.lv1;

import java.util.Arrays;

public class StringReverseOrder_12917 {
    public String solution(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder();
        for (int i = charArr.length - 1; i >= 0; i--) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}
