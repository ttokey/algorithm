package programmers.practice;

import java.util.*;
import java.util.stream.Collectors;

public class ChooseMandarin_138476 {

    public int solution(int k, int[] tangerineList) {
        int answer = 0;
        PriorityQueue<Map.Entry<Integer, Long>> tangerineQueue = new PriorityQueue<>((a, b) -> (int) (b.getValue() - a.getValue()));
        Arrays.stream(tangerineList)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .forEach(e -> tangerineQueue.add(e));
        while (k > 0) {
            k -= tangerineQueue.poll().getValue();
            answer++;
        }
        return answer;
    }

    public int solution2(int k, int[] tangerineList) {
        int answer = 0;
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int tangerine : tangerineList) {
            tangerineMap.put(tangerine, tangerineMap.getOrDefault(tangerine, 0) + 1);
        }
        List<Integer> tangerineCountList = tangerineMap.values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        for (int i = 0; i < tangerineCountList.size() && k > 0; i++) {
            k -= tangerineCountList.get(i);
            answer++;
        }
        return answer;
    }
}

