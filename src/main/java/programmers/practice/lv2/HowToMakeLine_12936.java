package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowToMakeLine_12936 {
    public int[] solution(int n, long k) {
        List<Integer> human = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> factMap = new HashMap<>();
        long fact = 1;
        for (int i = 1; i <= n - 1; i++) {
            fact *= i;
            factMap.put(i, fact);
            human.add(i);
        }
        human.add(n);
        k--;
        for (int i = n - 1; i >= 1; i--) {
            long divide = factMap.get(i);
            int index = (int) (k / divide);
            k = k % divide;
            result.add(human.get(index));
            human.remove(index);
        }
        result.add(human.get(0));
        int[] resultArr = new int[n];
        for (int i = 0; i < n; i++) {
            resultArr[i] = (int) result.get(i);
        }
        return resultArr;
    }

}
