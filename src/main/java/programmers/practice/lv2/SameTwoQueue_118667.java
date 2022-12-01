package programmers.practice.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class SameTwoQueue_118667 {
    public int solution(int[] queue1, int[] queue2) {
        SumQueue sumQueue1 = new SumQueue(queue1);
        SumQueue sumQueue2 = new SumQueue(queue2);

        long totalSum = sumQueue1.sum + sumQueue2.sum;
        long targetSum = totalSum / 2;
        int totalSize = sumQueue1.getSize() * 2;

        if (totalSum % 2 == 1) {
            return -1;
        }

        int count = 0;

        while (sumQueue1.sum != targetSum) {
            if (sumQueue1.sum < targetSum && !sumQueue2.isEmpty()) {
                sumQueue1.add(sumQueue2.poll());
                count++;
            } else if (sumQueue1.sum > targetSum && !sumQueue1.isEmpty()) {
                sumQueue2.add(sumQueue1.poll());
                count++;
            } else {
                return -1;
            }
            if (count > totalSize * 2) {
                return -1;
            }

        }
        return count;
    }

    public class SumQueue {
        long sum = 0;
        Queue<Integer> queue = new LinkedList<>();

        public SumQueue(int[] input) {
            this.queue = new LinkedList<>(Arrays.stream(input).boxed().collect(Collectors.toList()));
            this.sum = Arrays.stream(input).sum();
        }

        public Integer poll() {
            if (!queue.isEmpty()) {
                int result = queue.poll();
                sum -= result;
                return result;
            }
            return null;
        }

        public void add(int input) {
            sum += input;
            queue.add(input);
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public int getSize() {
            return queue.size();
        }
    }

}
