package programmers.practice.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class MazeExit_159993 {
    String[][] maze;

    public int solution(String[] maps) {
        maze = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < maps.length; i++) {
            maze[i] = maps[i].split("");
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j].equals("S")) {
                    start = new int[]{i, j};
                } else if (maze[i][j].equals("L")) {
                    lever = new int[]{i, j};
                } else if (maze[i][j].equals("E")) {
                    end = new int[]{i, j};
                }
            }
        }

        int toLever = bfs(start, lever, maze);
        int toEnd = bfs(lever, end, maze);
        return toLever == -1 || toEnd == -1 ? -1 : toLever + toEnd;
    }

    public int bfs(int[] start, int[] target, String[][] origin) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[][] maze = new String[origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            for (int j = 0; j < origin[0].length; j++) {
                maze[i][j] = origin[i][j];
            }
        }

        Queue<Node> bfs = new LinkedList<>();
        Node startNode = new Node(start, 0);
        bfs.add(startNode);
        maze[startNode.x][startNode.y] = "X";
        while (!bfs.isEmpty()) {
            Node now = bfs.poll();
            for (int[] direction : directions) {
                Node next = now.getNext(direction);
                if (next.x == target[0] && next.y == target[1]) {
                    return next.count;
                }
                if (next.isCanGo(maze)) {
                    maze[next.x][next.y] = "X";
                    bfs.add(next);
                }
            }
        }
        return -1;
    }

    public class Node {
        int x, y;
        int count;

        public Node(int[] input, int count) {
            this.x = input[0];
            this.y = input[1];
            this.count = count;
        }

        public Node getNext(int[] direction) {
            Node next = new Node(new int[]{x + direction[0], y + direction[1]}, count + 1);
            return next;
        }

        public boolean isCanGo(String[][] maze) {
            if (x < maze.length && x >= 0
                    && y < maze[0].length && y >= 0
                    && !maze[x][y].equals("X")) {
                return true;
            }
            return false;
        }
    }
}
