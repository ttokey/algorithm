package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class GetDistance_81302 {
    boolean[][] visited;
    boolean isDistance = false;

    public int[] solution(String[][] places) {
        List<Integer> result = new ArrayList<>();
        for (String[] place : places) {
            char[][] placeChar = new char[place.length][place[0].length()];
            visited = new boolean[place.length][place[0].length()];
            isDistance = false;
            for (int i = 0; i < place.length; i++) {
                placeChar[i] = place[i].toCharArray();
            }
            for (int i = 0; i < placeChar.length; i++) {
                for (int j = 0; j < placeChar[0].length; j++) {
                    if (placeChar[i][j] == 'P' && !isDistance) {
                        visited[i][j] = true;
                        findPerson(placeChar, 0, i, j);
                        visited[i][j] = false;

                    }
                }
            }
            if (isDistance) {
                result.add(0);
            } else {
                result.add(1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void findPerson(char[][] place, int distance, int y, int x) {
        if ((place[y][x] == 'P' && distance != 0) || isDistance) {
            isDistance = true;
            return;
        }
        if (distance == 2) {
            return;
        }
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int nextY = y + move[i][0];
            int nextX = x + move[i][1];

            if (nextY >= 0 && nextY < place.length
                    && nextX >= 0 && nextX < place[0].length
                    && place[nextY][nextX] != 'X'
                    && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                findPerson(place, distance + 1, nextY, nextX);
                visited[nextY][nextX] = false;
            }
        }
    }
}
