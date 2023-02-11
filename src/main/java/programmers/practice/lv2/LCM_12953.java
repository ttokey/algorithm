package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LCM_12953 {
    public int solution(int[] arr) {
        List<Map<Integer, Integer>> divisorList = new ArrayList<>();
        for (int input : arr) {
            divisorList.add(getDivisor(input));
        }
        Map<Integer, Integer> divisorMap = getDivisorMap(divisorList);
        return getResult(divisorMap);
    }

    public int getResult(Map<Integer, Integer> divisorMap) {
        int result = 1;
        for (int key : divisorMap.keySet()) {
            result *= Math.pow(key, divisorMap.get(key));
        }
        return result;
    }

    public Map<Integer, Integer> getDivisorMap(List<Map<Integer, Integer>> divisorList) {
        Map<Integer, Integer> result = new HashMap<>();
        for (Map<Integer, Integer> divisor : divisorList) {
            for (int key : divisor.keySet()) {
                result.put(key, Math.max(result.getOrDefault(key, 0), divisor.get(key)));
            }
        }
        return result;
    }

    public Map<Integer, Integer> getDivisor(int input) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 2; i <= input; i++) {
            while (input % i == 0) {
                result.put(i, result.getOrDefault(i, 0) + 1);
                input /= i;
            }
        }
        return result;
    }
}
