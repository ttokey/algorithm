package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DollClawGame_64061 {
    public int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> boardList = new ArrayList<>();
        for (int i = 0; i < board[0].length; i++) {
            Stack<Integer> s = new Stack<>();
            for (int j = board.length - 1; j >= 0; j--) {
                if (board[j][i] != 0) {
                    s.push(board[j][i]);
                }
            }
            boardList.add(s);
        }
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            int doll = 0;
            Stack<Integer> boardStack = boardList.get(move - 1);
            if (!boardStack.empty()) {
                doll = boardStack.pop();
            }
            if (doll != 0) {
                if (!bucket.empty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.add(doll);
                }
            }
        }
        return answer;
    }
}
