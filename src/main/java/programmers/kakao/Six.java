package programmers.kakao;

public class Six {
    public int solution(int[][] board, int[][] skill) {
        for (int i = 0; i < skill.length; i++) {
            board = doSkill(board, skill[i]);
        }
        int answer = countAlive(board);
        return answer;
    }

    public int countAlive(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int[][] doSkill(int[][] board, int[] skill) {
        int degree = skill[5];
        if (skill[0] == 1) {
            degree = -degree;
        }

        for (int i = skill[1]; i <= skill[3]; i++) {
            for (int j = skill[2]; j <= skill[4]; j++) {
                board[i][j] += degree;
            }
        }
        return board;
    }


}
