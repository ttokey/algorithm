package programmers.practice.lv1;

import java.util.HashMap;
import java.util.Map;

public class ParkWalk_172928 {
    public int[] solution(String[] park, String[] routes) {
        ParkMap parkMap = new ParkMap(park);
        Puppy puppy = new Puppy(parkMap.getStart());
        for (String route : routes) {
            puppy.move(route, parkMap);
        }
        return new int[]{puppy.x, puppy.y};
    }

    public class Puppy {
        int x;
        int y;

        public Puppy(int[] input) {
            this.x = input[0];
            this.y = input[1];
        }

        public void move(String route, ParkMap parkMap) {
            Map<String, Integer[]> dirMap = new HashMap<>();
            dirMap.put("N", new Integer[]{-1, 0});
            dirMap.put("S", new Integer[]{1, 0});
            dirMap.put("E", new Integer[]{0, 1});
            dirMap.put("W", new Integer[]{0, -1});

            String[] routeArray = route.split(" ");
            String dir = routeArray[0];
            int move = Integer.parseInt(routeArray[1]);
            int nextX = x;
            int nextY = y;
            for (int i = 0; i < move; i++) {
                nextX = nextX + dirMap.get(dir)[0];
                nextY = nextY + dirMap.get(dir)[1];
                if (!parkMap.canMove(nextX, nextY, routeArray[0])) {
                    return;
                }
            }
            this.x = nextX;
            this.y = nextY;
        }
    }

    public class ParkMap {
        boolean[][] map;
        int[] start;

        public ParkMap(String[] park) {
            map = new boolean[park.length][park[0].length()];
            start = new int[2];
            for (int i = 0; i < park.length; i++) {
                String[] row = park[i].split("");
                for (int j = 0; j < row.length; j++) {
                    map[i][j] = row[j].equals("X") ? false : true;
                    if (row[j].equals("S")) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
        }

        public int[] getStart() {
            return this.start;
        }

        public boolean canMove(int nextX, int nextY, String dir) {
            if (nextX >= 0 && nextX < map.length
                    && nextY >= 0 && nextY < map[0].length) {
                return map[nextX][nextY];
            }
            return false;
        }
    }
}
