package programmers.practice.lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SeesawPartner_152996 {
    public long solution(int[] weights) {
        Map<Integer, Integer> weightMap = new HashMap<>();
        Map<Integer, Integer> sameWeightMap = new HashMap<>();
        for (int weight : weights) {
            sameWeightMap.merge(weight, 1, Integer::sum);
        }
        for (int d = 2; d <= 4; d++) {
            for (int weight : weights) {
                weightMap.merge(weight * d, 1, Integer::sum);
            }
        }
        long answer = 0;
        for (int value : weightMap.values().stream().filter(v -> v >= 2).collect(Collectors.toList())) {
            answer += getCombination(value);
        }
        for (int value : sameWeightMap.values().stream().filter(v -> v >= 2).collect(Collectors.toList())) {
            answer -= 2 * getCombination(value);
        }
        return answer;
    }

    public long getCombination(int value) {
        return (long) value * (value - 1) / 2;
    }
}
