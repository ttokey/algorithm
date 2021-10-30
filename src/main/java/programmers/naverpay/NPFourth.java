package programmers.naverpay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NPFourth {
    public int solution(int[][] board) {

        Node[][] listMap = new Node[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            listMap[i][0] = new Node(Arrays.asList(board[i][0]));
            listMap[0][i] = new Node(Arrays.asList(board[0][i]));
        }


        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                List<Integer> toInput = new ArrayList<>();

                List<Integer> upper = listMap[i - 1][j].list;
                List<Integer> left = listMap[i][j - 1].list;
                for (int x = 0; x < upper.size(); x++) {
                    toInput.add(upper.get(x) + board[i][j]);
                    if (board[i][j] == 0) {
                        toInput.add(-upper.get(x));
                    }
                }
                for (int x = 0; x < left.size(); x++) {
                    toInput.add(left.get(x) + board[i][j]);
                    if (board[i][j] == 0) {
                        toInput.add(-left.get(x));
                    }
                }
                listMap[i][j] = new Node(toInput);
            }
        }

        int answer = listMap[board.length - 1][board[0].length - 1].list.stream().max(Comparator.naturalOrder()).get();
        return answer;
    }

    public class Node {
        List<Integer> list;

        public Node(List<Integer> input) {
            this.list = input;
        }

        public Node() {
            this.list = new ArrayList<>();
        }


    }


}
