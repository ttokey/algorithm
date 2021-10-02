package programmers.devMatching;
//
//https://programmers.co.kr/learn/courses/30/lessons/77485
//

import java.util.ArrayList;
import java.util.List;

public class RotatingEdge {
    public int[] solution(int rows, int columns, int[][] queries) {
        RotatingMap rotatingMap = new RotatingMap(rows, columns);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotatingMap.rotate(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
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
            List<Node> numbers = new ArrayList<>();
            for (int j = y1 - 1; j < y2 - 1; j++) {
                numbers.add(new Node(x1 - 1, j, nodes, 0));
            }
            for (int i = x1 - 1; i < x2 - 1; i++) {
                numbers.add(new Node(i, y2 - 1, nodes, 1));
            }
            for (int j = y2 - 1; j > y1 - 1; j--) {
                numbers.add(new Node(x2 - 1, j, nodes, 2));
            }
            for (int i = x2 - 1; i > x1 - 1; i--) {
                numbers.add(new Node(i, y1 - 1, nodes, 3));
            }
            for (Node node : numbers) {
                node.change(nodes);
            }
            return numbers.stream().mapToInt(node -> node.value).min().getAsInt();
        }

    }

    public class Node {
        int x;
        int y;
        int value;
        // 우 하 좌 상
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public Node(int x, int y, int[][] nodes, int move) {
            this.x = x + moves[move][0];
            this.y = y + moves[move][1];
            this.value = nodes[x][y];
        }

        public void change(int[][] nodes) {
            nodes[x][y] = value;
        }
    }
}
