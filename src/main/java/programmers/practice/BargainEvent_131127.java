package programmers.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BargainEvent_131127 {
    public int solution(String[] wants, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < wants.length; i++) {
            wantMap.put(wants[i], number[i]);
        }

        for (int i = 0; i < 10; i++) {
            minusValue(wantMap, discount[i]);
        }

        if (canJoin(wantMap)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            minusValue(wantMap, discount[i]);
            plusValue(wantMap, discount[i - 10]);
            if (canJoin(wantMap)) {
                answer++;
            }
        }
        return answer;
    }

    public boolean canJoin(Map<String, Integer> wantMap) {
        Set<Integer> wantSet = wantMap.values().stream().collect(Collectors.toSet());
        for (Integer want : wantSet) {
            if (want > 0) {
                return false;
            }
        }
        return true;
    }

    public void minusValue(Map<String, Integer> wantMap, String key) {
        wantMap.computeIfPresent(key, (k, v) -> --v);
    }

    public void plusValue(Map<String, Integer> wantMap, String key) {
        wantMap.computeIfPresent(key, (k, v) -> ++v);
    }
}
