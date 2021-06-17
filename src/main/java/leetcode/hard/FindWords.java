package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindWords {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visitedPath;
    int row, col;
    boolean isFind;

    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        col = board[0].length;
        Set<String> result = new HashSet<>();
        for (String word : words) {
            List<List<Integer>> start = startPoint(board, word.charAt(0));
            for (List<Integer> startPoint : start) {
                visitedPath = new boolean[row][col];
                int startRow = startPoint.get(0);
                int startCol = startPoint.get(1);
                isFind = false;
                if (word.length() == 1) {
                    isFind = true;
                } else {
                    visitedPath[startRow][startCol] = true;
                    dfs(board, word, 0, startRow, startCol);
                }
                if (isFind) {
                    result.add(word);
                }
            }
        }
        return result.stream().collect(Collectors.toList());
    }

    public List<List<Integer>> startPoint(char[][] board, char firstChar) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == firstChar) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }


    public void dfs(char[][] board, String word, int nowIndex, int nowRow, int nowCol) {
        if (nowIndex == word.length() - 1) {
            isFind = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int toRow = nowRow + dir[i][0];
            int toCol = nowCol + dir[i][1];
            if (toRow >= 0 && toRow < row && toCol >= 0 && toCol < col) {
                if (!visitedPath[toRow][toCol]) {
                    if (board[toRow][toCol] == word.charAt(nowIndex + 1)) {
                        visitedPath[toRow][toCol] = true;
                        dfs(board, word, nowIndex + 1, toRow, toCol);

                        visitedPath[toRow][toCol] = false;
                    }
                }
            }
        }
    }


}
