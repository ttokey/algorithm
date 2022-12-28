package programmers.practice.lv2;

import java.util.HashSet;
import java.util.Set;

public class RoadLength_49994 {
    public int solution(String dirs) {
        Node node = new Node();
        for (int i = 0; i < dirs.length(); i++) {
            node.move(dirs.charAt(i));
        }
        return node.getRoadSize();
    }

    public class Node {
        int x = 0, y = 0;
        Set<String> moveRoad = new HashSet<>();

        public Node() {
        }

        public int getRoadSize() {
            return moveRoad.size() / 2;
        }

        public void move(char dir) {
            int nextX = x;
            int nextY = y;
            if (dir == 'U') {
                nextY = Math.min(y + 1, 5);
            } else if (dir == 'R') {
                nextX = Math.min(x + 1, 5);
            } else if (dir == 'D') {
                nextY = Math.max(y - 1, -5);
            } else if (dir == 'L') {
                nextX = Math.max(x - 1, -5);
            }
            if (x != nextX || y != nextY) {
                StringBuilder move = new StringBuilder()
                        .append(y)
                        .append(x)
                        .append(nextX)
                        .append(nextY);
                StringBuilder move2 = new StringBuilder()
                        .append(nextY)
                        .append(nextX)
                        .append(x)
                        .append(y);
                moveRoad.add(move.toString());
                moveRoad.add(move2.toString());
            }
            x = nextX;
            y = nextY;
        }
    }
}
