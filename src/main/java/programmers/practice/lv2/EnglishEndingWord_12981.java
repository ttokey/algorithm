package programmers.practice.lv2;

import java.util.HashSet;
import java.util.Set;

public class EnglishEndingWord_12981 {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        int[] answer = new int[2];
        for (int i = 1; i < words.length; i++) {
            if (!wordSet.add(words[i]) || !isCorrect(words, i)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }
        return answer;
    }

    public boolean isCorrect(String[] words, int index) {
        String before = words[index - 1];
        String after = words[index];
        System.out.println(before + " " + after);
        return before.charAt(before.length() - 1) == after.charAt(0);
    }
}

