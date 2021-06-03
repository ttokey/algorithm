//https://leetcode.com/problems/unique-paths-iii/

//On a 2-dimensional grid, there are 4 types of squares:
//
//1 represents the starting square.  There is exactly one starting square.
//2 represents the ending square.  There is exactly one ending square.
//0 represents empty squares we can walk over.
//-1 represents obstacles that we cannot walk over.
//Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//
//
//Example 1:
//
//Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
//Output: 2
//Explanation: We have the following two paths:
//1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

//https://hoyoungmoon.github.io/java/find-short-cut/
package leetcode.hard;

public class UniquePathsIII {
    int[][] grid;
    boolean[][] visitedPath;
    int row, col;
    int countZero;
    int getRuteCount = 0;
    int[] moveRow = {-1, 0, 1, 0};
    int[] moveCol = {0, -1, 0, 1};
    int startRow, startCol;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        visitedPath = new boolean[row][col];
        getCountZero();
        findStart();
        visitedPath[startRow][startCol] = true;
        dfs(startRow, startCol, 0);
        return getRuteCount;
    }


    public void dfs(int nowRow, int nowCol, int depth) {
        if (grid[nowRow][nowCol] == 2 && depth == countZero + 1) {
            getRuteCount++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int toRow = nowRow + moveRow[i];
            int toCol = nowCol + moveCol[i];
            if (toRow >= 0 && toRow < row && toCol >= 0 && toCol < col) {
                if (grid[toRow][toCol] != -1 && !visitedPath[toRow][toCol]) {
                    visitedPath[toRow][toCol] = true;

                    dfs(toRow, toCol, depth + 1);
                    visitedPath[toRow][toCol] = false;
                }
            }
        }

    }

    public void findStart() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                    return;
                }
            }
        }
    }


    public void getCountZero() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    countZero++;
                }
            }
        }
    }


}
