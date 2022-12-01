package programmers.practice.lv2;

import java.util.Arrays;

public class Dictionary_84512 {
    int count = 0;
    int result = 0;

    public int solution(String word) {
        int[] nowWord = {0, 0, 0, 0, 0};
        int[] targetWord = transWord(word);
        dfs(nowWord, 0, targetWord);
        return result;
    }

    public void dfs(int[] nowWord, int index, int[] targetWord) {
        if (Arrays.equals(targetWord, nowWord)) {
            result = count;
            return;
        }

        if (index >= 5 || result != 0) {
            return;
        }

        for (int i = 1; i <= 5; i++) {
            int[] newWord = nowWord.clone();
            count++;
            newWord[index] = i;
            dfs(newWord, index + 1, targetWord);
        }
    }

    public int[] transWord(String word) {
        char[] words = word.toCharArray();
        int[] result = {0, 0, 0, 0, 0};

        for (int i = 0; i < words.length; i++) {
            if (words[i] == 'A') {
                result[i] = 1;
            } else if (words[i] == 'E') {
                result[i] = 2;
            } else if (words[i] == 'I') {
                result[i] = 3;
            } else if (words[i] == 'O') {
                result[i] = 4;
            } else if (words[i] == 'U') {
                result[i] = 5;
            }
        }
        return result;
    }
}
