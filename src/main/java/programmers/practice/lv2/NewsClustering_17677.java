package programmers.practice.lv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NewsClustering_17677 {
    public int solution(String str1, String str2) {
        Map<String, Integer> str1Map = getStringMap(str1);
        Map<String, Integer> str2Map = getStringMap(str2);
        return getJaccard(str1Map, str2Map);
    }

    public int getJaccard(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.isEmpty() && map2.isEmpty()) {
            return 1 * 65536;
        }
        int intersectionCount = 0;
        int sumOfSetCount = 0;
        Set<String> keySet = new HashSet<>();
        keySet.addAll(map1.keySet());
        keySet.addAll(map2.keySet());
        for (String key : keySet) {
            int map1ValueSize = map1.getOrDefault(key, 0);
            int map2ValueSize = map2.getOrDefault(key, 0);
            intersectionCount += Math.min(map1ValueSize, map2ValueSize);
            sumOfSetCount += Math.max(map1ValueSize, map2ValueSize);
        }
        return (int) ((double) intersectionCount / sumOfSetCount * 65536);
    }

    public Map<String, Integer> getStringMap(String input) {
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < input.length() - 1; i++) {
            String toInputString = input.substring(i, i + 2);
            toInputString = toInputString.toUpperCase();
            if (toInputString.matches("[A-Z]{2}")) {
                result.put(toInputString, result.getOrDefault(toInputString, 0) + 1);
            }
        }
        return result;
    }
}
