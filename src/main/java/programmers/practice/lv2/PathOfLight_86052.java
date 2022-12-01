package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class PathOfLight_86052 {
    public int[] solution(String[] grid) {
        Path path = new Path(grid);
        List<Integer> answer = new ArrayList<>();
        boolean[][][] used = new boolean[grid.length][grid[0].length()][4];

        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < used[0].length; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!used[i][j][k]) {
                        Light light = new Light(j, i, k, grid[0].length(), grid.length);
                        answer.add(light.getRoute(used, path));
                    }
                }
            }
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }

    public class Light {
        int x;
        int y;
        int nextDirection;
        int routeLength;
        int maxX;
        int maxY;
        int firstX;
        int firstY;
        int firstDirection;

        public Light(int x, int y, int direction, int maxX, int maxY) {
            this.x = x;
            this.y = y;
            this.firstX = x;
            this.firstY = y;
            this.firstDirection = direction;
            this.nextDirection = direction;
            this.maxX = maxX;
            this.maxY = maxY;
            this.routeLength = 0;
        }

        public int getRoute(boolean[][][] used, Path path) {
            while (true) {
                moveNext(nextDirection, used);
                nextDirection = path.getNextDirection(nextDirection, x, y);
                if (x == firstX && y == firstY) {
                    if (nextDirection == firstDirection) {
                        break;
                    }
                }
            }
            return routeLength;
        }

        private void moveNext(int direction, boolean[][][] used) {
            //0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽
            int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            used[y][x][nextDirection] = true;
            this.x = (this.x + move[direction][1] + maxX) % maxX;
            this.y = (this.y + move[direction][0] + maxY) % maxY;
            routeLength++;
        }
    }

    public class Path {
        char[][] pathMap;

        public Path(String[] grid) {
            pathMap = new char[grid.length][grid[0].length()];
            for (int i = 0; i < grid.length; i++) {
                pathMap[i] = grid[i].toCharArray();
            }
        }

        //0 : 위쪽, 1 : 오른쪽, 2 : 아래쪽, 3 : 왼쪽
        public int getNextDirection(int direction, int x, int y) {
            char node = pathMap[y][x];
            if (node == 'S') {
                return direction;
            } else if (node == 'L') {
                return (direction + 3) % 4;
            }
            return (direction + 1) % 4;
        }
    }
}
