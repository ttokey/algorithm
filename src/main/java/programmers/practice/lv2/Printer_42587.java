package programmers.practice.lv2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer_42587 {
    public int solution(int[] priorities, int location) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> priorityQueue = new LinkedList<>();
        for (int priority : priorities) {
            pq.add(priority);
            priorityQueue.add(priority);
        }
        while (!pq.isEmpty()) {
            if (pq.peek() <= priorityQueue.peek()) {
                count++;
                if (location == 0) {
                    break;
                }
                location = (location + pq.size() - 1) % pq.size();
                pq.poll();
                priorityQueue.poll();
            } else {
                location = (location + pq.size() - 1) % pq.size();
                priorityQueue.add(priorityQueue.poll());
            }
        }
        return count;
    }
}
