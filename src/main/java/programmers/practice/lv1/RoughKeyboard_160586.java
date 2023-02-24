package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoughKeyboard_160586 {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();
        for (String key : keymap) {
            String[] keyArr = key.split("");
            for (int i = 1; i <= keyArr.length; i++) {
                map.put(keyArr[i - 1], Math.min(map.getOrDefault(keyArr[i - 1], 111), i));
            }
        }
        List<Integer> result = new ArrayList<>();
        for (String target : targets) {
            int answer = 0;
            String[] targetArr = target.split("");
            for (String key : targetArr) {
                if (map.containsKey(key)) {
                    answer += map.get(key);
                } else {
                    answer = -1;
                    break;
                }
            }
            result.add(answer);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
