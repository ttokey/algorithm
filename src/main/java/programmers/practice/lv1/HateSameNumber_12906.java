package programmers.practice.lv1;

import java.util.Stack;

public class HateSameNumber_12906 {
    public int[] solution(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for (int num : arr) {
            if (s.isEmpty() || s.peek() != num) {
                s.add(num);
            }
        }
        return s.stream().mapToInt(i -> i).toArray();
    }
}
