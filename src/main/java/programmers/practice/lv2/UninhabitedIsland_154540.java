package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UninhabitedIsland_154540 {
    public int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>();
        char[][] charMap = new char[maps.length][maps[0].length()];
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[0].length; j++) {
                charMap[i][j] = maps[i].charAt(j);
            }
        }
        for (int i = 0; i < charMap.length; i++) {
            for (int j = 0; j < charMap[0].length; j++) {
                if (charMap[i][j] != 'X') {
                    answerList.add(bfs(charMap, i, j));
                }
            }
        }
        if (answerList.size() == 0) {
            answerList.add(-1);
        }
        return answerList.stream().sorted().mapToInt(i -> i).toArray();
    }

    public int bfs(char[][] charMap, int x, int y) {
        int result = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> iq = new LinkedList<>();
        Queue<Integer> jq = new LinkedList<>();
        if (charMap[x][y] != 'X') {
            result += Integer.parseInt(String.valueOf(charMap[x][y]));
            charMap[x][y] = 'X';
        }
        iq.add(x);
        jq.add(y);
        while (!iq.isEmpty()) {
            int i = iq.poll();
            int j = jq.poll();
            for (int k = 0; k < 4; k++) {
                int nexti = i + dir[k][0];
                int nextj = j + dir[k][1];
                if (nexti >= 0 && nexti < charMap.length && nextj >= 0 && nextj < charMap[0].length) {
                    if (charMap[nexti][nextj] != 'X') {
                        iq.add(nexti);
                        jq.add(nextj);
                        result += Integer.parseInt(String.valueOf(charMap[nexti][nextj]));
                        charMap[nexti][nextj] = 'X';
                    }
                }
            }
        }
        return result;
    }
}
