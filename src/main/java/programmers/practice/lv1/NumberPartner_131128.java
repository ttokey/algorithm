package programmers.practice.lv1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberPartner_131128 {
    public String solution(String X, String Y) {
        Map<Integer, Integer> XMap = new HashMap<>();
        Map<Integer, Integer> YMap = new HashMap<>();
        makeMap(XMap, X);
        makeMap(YMap, Y);
        Map<Integer, Integer> answerMap = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            int min = Math.min(XMap.getOrDefault(i, 0), YMap.getOrDefault(i, 0));
            if (min > 0) {
                answerMap.put(i, min);
            }
        }
        if (answerMap.isEmpty()) {
            return "-1";
        }
        StringBuilder sb = new StringBuilder();
        for (int key : answerMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            for (int i = 0; i < answerMap.get(key); i++) {
                sb.append(key);
            }
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public void makeMap(Map<Integer, Integer> inputMap, String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            int key = Integer.valueOf(inputString.substring(i, i + 1));
            inputMap.merge(key, 1, Integer::sum);
        }
    }
}
