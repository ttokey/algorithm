package programmers.practice.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class CrossBridgeTruck_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQueue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridgeQueue.add(0);
        }
        int totalWeight = 0;
        int time = 0;
        int truckIndex = 0;
        do {
            time++;
            totalWeight -= bridgeQueue.poll();
            if (truckIndex < truck_weights.length && totalWeight + truck_weights[truckIndex] <= weight) {
                bridgeQueue.add(truck_weights[truckIndex]);
                totalWeight += truck_weights[truckIndex];
                truckIndex++;
            } else {
                bridgeQueue.add(0);
            }
        } while (totalWeight != 0);
        return time;
    }
}
