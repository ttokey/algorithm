package programmers.practice.lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TransNumber_154538 {
    public int solution(int x, int y, int n) {
        int[] array = new int[1000001];
        Arrays.fill(array, -1);
        array[x] = 0;
        for (int i = x + 1; i <= y; i++) {
            array[i] = getArrayValue(array, i, n);
        }
        return array[y];
    }

    public int getArrayValue(int[] array, int index, int plus) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        if (index - plus >= 0 && array[index - plus] != -1) {
            pq.add(array[index - plus] + 1);
        }
        for (int i = 2; i <= 3; i++) {
            if (index % i == 0 && index / i >= 0 && array[index / i] != -1) {
                pq.add(array[index / i] + 1);
            }
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}
