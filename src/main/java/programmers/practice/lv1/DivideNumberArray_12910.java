package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.List;

public class DivideNumberArray_12910 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) {
                result.add(num);
            }
        }
        if (result.isEmpty()) {
            return new int[]{-1};
        }
        return result.stream().sorted().mapToInt(i -> i).toArray();
    }
}
