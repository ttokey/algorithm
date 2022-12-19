package programmers.practice.lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class MaxExpression_67257 {
    public long solution(String expression) {
        Queue<Long> numberQueue = new LinkedList<>(Arrays.stream(expression.split("\\*|\\-|\\+")).map(s -> Long.valueOf(s)).collect(Collectors.toList()));
        Queue<String> operationQueue = new LinkedList<>(Arrays.stream(expression.split("\\d")).filter(s -> !s.equals("")).collect(Collectors.toList()));
        String[][] operationArray = {{"*", "+", "-"}, {"*", "-", "+"}
                , {"+", "*", "-"}, {"+", "-", "*"}
                , {"-", "+", "*"}, {"-", "*", "+"}};
        long answer = -1;

        for (int i = 0; i < operationArray.length; i++) {
            Queue<Long> copiedNumberQueue = new LinkedList<>(numberQueue.stream().collect(Collectors.toList()));
            Queue<String> copiedOperationQueue = new LinkedList<>(operationQueue.stream().collect(Collectors.toList()));
            Stack<Long> numberStack = new Stack<>();
            Stack<String> operationStack = new Stack<>();
            for (int j = 0; j < 3; j++) {
                numberStack = new Stack<>();
                operationStack = new Stack<>();
                numberStack.push(copiedNumberQueue.poll());
                while (!copiedNumberQueue.isEmpty()) {
                    String operation = copiedOperationQueue.poll();
                    long num2 = copiedNumberQueue.poll();
                    if (operation.equals(operationArray[i][j])) {
                        long num1 = numberStack.pop();
                        numberStack.push(calc(num1, num2, operation));
                    } else {
                        numberStack.push(num2);
                        operationStack.push(operation);
                    }
                }
                copiedNumberQueue = new LinkedList<>(numberStack.stream().collect(Collectors.toList()));
                copiedOperationQueue = new LinkedList<>(operationStack.stream().collect(Collectors.toList()));
            }
            answer = Math.max(answer, Math.abs(numberStack.pop()));
        }
        return answer;
    }

    public long calc(long num1, long num2, String operation) {
        long result = 0;
        if (operation.equals("*")) {
            result = num1 * num2;
        } else if (operation.equals("+")) {
            result = num1 + num2;
        } else if (operation.equals("-")) {
            result = num1 - num2;
        }
        return result;
    }
}
