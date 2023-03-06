package programmers.practice.lv2;

public class FindLargestSquare_12905 {
    public int solution(int[][] board) {
        if (isZero(board)) {
            return 0;
        }
        int answer = 1;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    int vertical = board[i - 1][j];
                    int horizon = board[i][j - 1];
                    int diagonal = board[i - 1][j - 1];
                    int minPerimeter = Math.min(vertical, Math.min(horizon, diagonal)) + 1;
                    board[i][j] = minPerimeter;
                    answer = Math.max(answer, minPerimeter);
                }
            }
        }
        return (int) Math.pow(answer, 2);
    }

    public boolean isZero(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
