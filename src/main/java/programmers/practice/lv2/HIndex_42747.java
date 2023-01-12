package programmers.practice.lv2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex_42747 {
    public int solution(int[] citations) {
        Integer[] citationsInteger = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(citationsInteger, Collections.reverseOrder());
        int h = citationsInteger[0];
        for (int i = 0; i < citationsInteger.length - 1; i++) {
            while (h > citationsInteger[i + 1]) {
                if (i + 1 >= h && h >= citationsInteger.length - i - 1) {
                    return h;
                } else {
                    h--;
                }
            }
        }

        while (h >= 0) {
            if (citationsInteger.length >= h && h >= 0) {
                return h;
            } else {
                h--;
            }
        }
        return h;
    }
}
