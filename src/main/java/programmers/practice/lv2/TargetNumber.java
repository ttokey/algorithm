package programmers.practice.lv2;

//https://programmers.co.kr/learn/courses/30/lessons/43165?language=java

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return bfs(numbers, target);
    }

    public int bfs(int[] numbers, int target) {
        Queue<Node> queue = new LinkedList<>();
        int count = 0;
        queue.add(new Node(0, -numbers[0]));
        queue.add(new Node(0, numbers[0]));

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();
            if (nowNode.index == numbers.length - 1) {
                if (nowNode.getSum() == target) {
                    count++;
                }
            } else {
                queue.add(new Node(nowNode.getIndex() + 1, nowNode.getSum() + numbers[nowNode.getIndex() + 1]));
                queue.add(new Node(nowNode.getIndex() + 1, nowNode.getSum() - numbers[nowNode.getIndex() + 1]));
            }
        }
        return count;
    }

    class Node {
        int index;
        int sum;

        public Node(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        public int getIndex() {
            return this.index;
        }

        public int getSum() {
            return this.sum;
        }
    }

}
