package programmers.practice.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberTypingContest_136797 {
    int[][] cache = new int[10][10];
    int[] num;

    public int solution(String numbers) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cache[i][j] = getDistance(i, j);
            }
        }
        num = Arrays.stream(numbers.split("")).mapToInt(s -> (int) Integer.parseInt(s)).toArray();
        return getAnswer();
    }

    public int getAnswer() {
        int[][] map = new int[10][10];
        Queue<String> q = new LinkedList<>();
        q.add("46");
        for (int targetNum : num) {
            List<String> nextFingerList = new ArrayList<>();
            int[][] tempMap = map;
            map = new int[10][10];
            while (!q.isEmpty()) {
                int[] nowFinger = Arrays.stream(q.poll().split("")).mapToInt(s -> (int) Integer.parseInt(s)).toArray();
                int beforeWeight = tempMap[nowFinger[0]][nowFinger[1]];
                int[][] nextFingerArray = {{targetNum, nowFinger[1]}, {nowFinger[0], targetNum}};
                for (int i = 0; i < 2; i++) {
                    int[] nextFinger = nextFingerArray[i];
                    int beforeNum = nowFinger[i];
                    if (nextFinger[0] != nextFinger[1]) {
                        int sumWeight = beforeWeight + cache[beforeNum][targetNum];
                        int targetWeight = map[nextFinger[0]][nextFinger[1]];
                        if (targetWeight == 0 || targetWeight > sumWeight) {
                            map[nextFinger[0]][nextFinger[1]] = sumWeight;
                            map[nextFinger[1]][nextFinger[0]] = sumWeight;
                            StringBuilder sb = new StringBuilder().append(nextFinger[0]).append(nextFinger[1]);
                            nextFingerList.add(sb.toString());
                        }
                    }
                }
            }
            q.addAll(nextFingerList);
        }
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] nowFinger = Arrays.stream(q.poll().split("")).mapToInt(s -> (int) Integer.parseInt(s)).toArray();
            int weight = map[nowFinger[0]][nowFinger[1]];
            min = Math.min(min, weight);
        }
        return min;
    }

    public int getDistance(int location, int target) {
        if (location == target) {
            return 1;
        }
        int[] nowPoint = getPoint(location);
        int[] targetPoint = getPoint(target);
        int[] diff = {Math.abs(nowPoint[0] - targetPoint[0]), Math.abs(nowPoint[1] - targetPoint[1])};
        int min = Math.min(diff[0], diff[1]);
        int other = Math.max(diff[0], diff[1]) - min;
        return min * 3 + other * 2;
    }

    public int[] getPoint(int input) {
        int[] result = new int[2];
        if (input == 0) {
            result[0] = 3;
            result[1] = 1;
        } else {
            result[0] = (input - 1) / 3;
            result[1] = (input - 1) % 3;
        }
        return result;
    }
}
