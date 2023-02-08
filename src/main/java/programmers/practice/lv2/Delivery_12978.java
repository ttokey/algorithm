package programmers.practice.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Delivery_12978 {
    public int solution(int N, int[][] roads, int K) {
        int[] distanceArray = new int[N + 1];
        int[][] map = new int[N + 1][N + 1];
        for (int[] road : roads) {
            if (map[road[0]][road[1]] == 0 || map[road[0]][road[1]] > road[2]) {
                map[road[0]][road[1]] = road[2];
                map[road[1]][road[0]] = road[2];
            }
        }
        Queue<Integer> cityQueue = new LinkedList<>();
        cityQueue.add(1);
        while (!cityQueue.isEmpty()) {
            int city = cityQueue.poll();
            for (int i = 2; i <= N; i++) {
                int distance = map[city][i];
                if (distance != 0) {
                    if (distanceArray[i] == 0) {
                        distanceArray[i] = distanceArray[city] + distance;
                        cityQueue.add(i);
                    } else if (distanceArray[i] > distanceArray[city] + distance) {
                        distanceArray[i] = distanceArray[city] + distance;
                        cityQueue.add(i);
                    }
                }
            }
        }
        return (int) Arrays.stream(distanceArray).filter(distance -> distance > 0 && distance <= K).count() + 1;
    }
}
