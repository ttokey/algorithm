package programmers.practice.lv3;

import java.util.ArrayList;
import java.util.List;

public class TwoDimensionCoinReverse_131703 {
    public int solution(int[][] beginning, int[][] target) {
        int[] moveArray = {0, beginning.length};
        List<Integer> result = new ArrayList<>();
        for (int move : moveArray) {
            for (boolean flag : new boolean[]{false, true}) {
                CoinSquare coinSquare = new CoinSquare(beginning);
                if (flag) {
                    coinSquare.move(move);
                }
                int count = coinSquare.getCount(target);
                if (count != -1) {
                    result.add(count);
                }
            }
        }
        CoinSquare coinSquare = new CoinSquare(beginning);
        coinSquare.move(moveArray[0]);
        coinSquare.move(moveArray[1]);
        int count = coinSquare.getCount(target);
        if (count != -1) {
            result.add(count);
        }
        return result.isEmpty() ? -1 : result.stream().mapToInt(i -> i).min().getAsInt();
    }

    public class CoinSquare {
        int[][] map;
        boolean[] visited;

        public CoinSquare(int[][] input) {
            this.map = new int[input.length][input[0].length];
            for (int i = 0; i < this.map.length; i++) {
                for (int j = 0; j < this.map[0].length; j++) {
                    this.map[i][j] = input[i][j];
                }
            }
            this.visited = new boolean[getLength()];
        }

        public int getLength() {
            return map.length + map[0].length;
        }

        public int getCount(int[][] target) {
            List<Integer> moveList = getMoveList(target);
            for (int n : moveList) {
                move(n);
            }
            if (isEqual(target)) {
                return getVisitCount();
            }
            return -1;
        }

        public void move(int n) {
            if (n < map.length) {
                for (int i = 0; i < map[0].length; i++) {
                    map[n][i] = map[n][i] == 0 ? 1 : 0;
                }
            } else {
                int temp = n - map.length;
                for (int i = 0; i < map.length; i++) {
                    map[i][temp] = map[i][temp] == 0 ? 1 : 0;
                }
            }
            visited[n] = true;
        }

        public List<Integer> getMoveList(int[][] target) {
            List<Integer> result = new ArrayList<>();
            for (int n = 0; n < getLength(); n++) {
                if (!visited[n]) {
                    if (n < map.length) {
                        if (map[n][0] != target[n][0]) {
                            result.add(n);
                        }
                    } else {
                        int temp = n - map.length;
                        if (map[0][temp] != target[0][temp]) {
                            result.add(n);
                        }
                    }
                }
            }
            return result;
        }

        public int getVisitCount() {
            int result = 0;
            for (boolean visit : visited) {
                if (visit) {
                    result++;
                }
            }
            return result;
        }

        public boolean isEqual(int[][] input) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[0].length; j++) {
                    if (this.map[i][j] != input[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
