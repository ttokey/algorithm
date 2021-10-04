package programmers.devMatching;

//https://programmers.co.kr/learn/courses/30/lessons/77485

import java.util.ArrayList;
import java.util.List;

public class RotatingEdge {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        return answer;
    }

    public class RotatingMap {
        int[][] nodes;

        public RotatingMap(int rows, int columns) {
            nodes = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.nodes[i][j] = i * columns + j + 1;
                }
            }
        }

        public int rotate(int x1, int y1, int x2, int y2) {
            // 우 하 좌 상
            int[][] moves = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
            List<Integer> numbers = new ArrayList<>();
            for (int i = x1 - 1; i < x2 - 1; i++) {
                numbers.add(nodes[i][y1 - 1]);
            }
            for (int j = y1 - 1; j < y2 - 1; j++) {
                numbers.add(nodes[x2 - 1][j]);
            }
            for (int i = x2 - 1; i >= x1 - 1; i--) {

            }
            return 0;

        }

    }

    public class Node {
        int x;
        int y;
        int value;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
