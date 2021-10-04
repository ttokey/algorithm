package programmers.baemin;

import java.util.ArrayList;
import java.util.List;

public class Baemin2 {
    int maxRow;
    int maxColumn;
    int totalCount;

    public int[] solution(int n) {
        int[][] map = makeMap(n);
        return printMap(map);
    }

    public int[] printMap(int[][] map) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    result.add(map[i][j]);
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }


    public int[][] makeMap(int n) {
        maxRow = 4 * n - 3;
        maxColumn = 2 * n - 1;
        totalCount = 3 * n * n - 3 * n + 1;
        int[][] move = {{1, 1}, {2, 0}, {1, -1}, {-1, -1}, {-2, 0}, {-1, 1}};

        int[][] map = new int[maxRow][maxColumn];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                map[i][j] = -1;
                map[i][maxColumn - 1 - j] = -1;
                map[maxRow - 1 - i][j] = -1;
                map[maxRow - 1 - i][maxColumn - 1 - j] = -1;
            }
        }

        int row = 0;
        int column = n - 1;
        int direction = 0;

        for (int i = 1; i <= totalCount; i++) {
            map[row][column] = i;
            if (i == totalCount) {
                break;
            }
            if (!isCanMove(map, row + move[direction][0], column + move[direction][1])) {
                direction = (direction + 1) % 6;
                while (!isCanMove(map, row + move[direction][0], column + move[direction][1])) {
                    direction = (direction + 1) % 6;
                }
            }
            row = row + move[direction][0];
            column = column + move[direction][1];
        }
        return map;
    }

    public boolean isCanMove(int[][] map, int toRow, int toColumn) {
        if (toRow < 0 || toRow >= maxRow || toColumn < 0 || toColumn >= maxColumn) {
            return false;
        }
        if (map[toRow][toColumn] != 0) {
            return false;
        }
        return true;
    }


}
