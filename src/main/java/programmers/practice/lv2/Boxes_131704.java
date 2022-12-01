package programmers.practice.lv2;

import java.util.Stack;

public class Boxes_131704 {
    public int solution(int[] order) {
        Stack<Integer> tempBelt = new Stack<>();
        int orderIndex = 0;
        int count = 0;
        for (int box = 1; box <= order.length; box++) {
            if (box == order[orderIndex]) {
                count++;
                orderIndex++;
            } else {
                tempBelt.push(box);
            }
            while (!tempBelt.isEmpty() && tempBelt.peek() == order[orderIndex]) {
                count++;
                orderIndex++;
                tempBelt.pop();
            }
        }
        return count;
    }
}
