package programmers.practice.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MemoryScore_176963 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> memoryMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            memoryMap.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            answer[i] = Arrays.stream(photo[i]).mapToInt(s -> memoryMap.getOrDefault(s, 0)).sum();
        }
        return answer;
    }
}
