package programmers.practice.lv2;

import java.util.Stack;

public class RemoveCoupleString_12973 {
    public int solution(String s) {
        char[] inputArray = s.toCharArray();
        Stack<Character> inputStack = new Stack<>();
        for (char input : inputArray) {
            if (!inputStack.isEmpty() && inputStack.peek() == input) {
                inputStack.pop();
            } else {
                inputStack.add(input);
            }
        }
        return inputStack.isEmpty() ? 1 : 0;
    }
}
