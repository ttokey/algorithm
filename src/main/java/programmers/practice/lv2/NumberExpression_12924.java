package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class NumberExpression_12924 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int target = 2 * n + i * i - i;
            List<Integer> divide = getDivide(i, target);
            for (int j : divide) {
                int temp = j * j + j;
                if (temp == target) {
                    answer++;
                    break;
                } else if (temp > target) {
                    break;
                }
            }
        }
        return answer;
    }

    public List<Integer> getDivide(int start, int target) {
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= Math.sqrt(target); i++) {
            if (target % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
