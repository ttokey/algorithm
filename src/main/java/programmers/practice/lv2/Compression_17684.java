package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression_17684 {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> LZWMap = new HashMap<>();
        int maxLength = 1;
        int maxValue = 26;
        for (int i = 65; i < 91; i++) {
            char temp = (char) i;
            LZWMap.put(String.valueOf(temp), i - 64);
        }
        while (!msg.isEmpty()) {
            int index = Math.min(maxLength, msg.length());
            while (!LZWMap.keySet().contains(msg.substring(0, index))) {
                index--;
            }
            String key = msg.substring(0, index);
            msg = msg.replaceFirst(key, "");
            result.add(LZWMap.get(key));
            if (!msg.isEmpty()) {
                String keyPlus = key + msg.substring(0, 1);
                LZWMap.put(keyPlus, ++maxValue);
                maxLength = Math.max(keyPlus.length(), maxLength);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
