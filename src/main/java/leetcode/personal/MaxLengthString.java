package leetcode.personal;

/*
example1.
input "abcabdddddd"
        234
output 4 (cabd)
example2.
input "bbbbbbbbbb"
output 1 (b)
example3.
input "abaaaaabapa"
output 3 (bap)
 */

import java.util.HashMap;
import java.util.Map;

public class MaxLengthString {
    public static int maxLengthString(String word) {
        Map<Character, Integer> m = new HashMap<>();
        if (word.length() <= 1) {
            return word.length();
        }
        int max = 0;
        int cursor = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (m.containsKey(c)) {
                if (m.get(c) > cursor) {
                    max = Math.max(max, m.size());
                } else {
                    max = Math.max(max, i - cursor);
                }
                cursor = m.get(c) + 1;
            }
            m.put(word.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
        int output = maxLengthString("abcabdddddd");
        System.out.println(output);
    }
}
