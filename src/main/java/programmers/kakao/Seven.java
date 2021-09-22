package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

public class Seven {
    int[][] visited;
    int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int minCount = Integer.MAX_VALUE;

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        visited = board;
        Node firstNode = new Node(1, aloc[0], aloc[1], bloc[0], bloc[1], 0);
        dfs(firstNode);
        return minCount;
    }

    public void dfs(Node nowNode) {
        List<Node> nodeList = nowNode.getNext();
        if (nodeList.isEmpty() || !nowNode.isCanMove()) {
            minCount = Math.min(minCount, nowNode.getCount());
            return;
        }

        for (Node node : nodeList) {
            nowNode.makeVisited();
            dfs(node);
            nowNode.makeNotVisited();
        }
    }


    public class Node {
        int nowMovePlayer;
        int a_x;
        int a_y;
        int b_x;
        int b_y;
        int count;

        public Node(int nowMovePlayer, int a_x, int a_y, int b_x, int b_y, int count) {
            this.nowMovePlayer = nowMovePlayer;
            this.a_x = a_x;
            this.a_y = a_y;
            this.b_x = b_x;
            this.b_y = b_y;
            this.count = count;
        }

        public boolean isCanMove() {
            boolean result = true;
            if (nowMovePlayer == 1) {
                if (visited[a_x][a_y] == 0) {
                    result = false;
                }
            } else {
                if (visited[b_x][b_y] == 0) {
                    result = false;
                }
            }
            return result;
        }

        public void makeVisited() {
            if (nowMovePlayer == 1) {
                visited[a_x][a_y] = 0;
            } else {
                visited[b_x][b_y] = 0;
            }
        }

        public void makeNotVisited() {
            if (nowMovePlayer == 1) {
                visited[a_x][a_y] = 1;
            } else {
                visited[b_x][b_y] = 1;
            }
        }

        public int getCount() {
            return this.count;
        }

        public List<Node> getNext() {
            List<Node> result = new ArrayList<>();
            if (nowMovePlayer == 2) {
                for (int i = 0; i < 4; i++) {
                    int to_x = b_x + move[i][0];
                    int to_y = b_y + move[i][1];
                    if (to_x >= 0 && to_x < visited.length && to_y >= 0 && to_y < visited[0].length && visited[to_x][to_y] == 1) {
                        Node node = new Node(1, a_x, a_y, to_x, to_y, count + 1);
                        result.add(node);
                    }
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int to_x = a_x + move[i][0];
                    int to_y = a_y + move[i][1];
                    if (to_x >= 0 && to_x < visited.length && to_y >= 0 && to_y < visited[0].length && visited[to_x][to_y] == 1) {
                        Node node = new Node(2, to_x, to_y, b_x, b_y, count + 1);
                        result.add(node);
                    }
                }
            }
            return result;
        }
    }
}


