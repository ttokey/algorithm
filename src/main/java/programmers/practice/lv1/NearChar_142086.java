package programmers.practice.lv1;

import java.util.HashMap;
import java.util.Map;

public class NearChar_142086 {
    public int[] solution(String s) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                answer[i] = i - charMap.get(c);
                charMap.put(c, i);
            } else {
                answer[i] = -1;
                charMap.put(c, i);
            }
        }
        return answer;
    }
}
