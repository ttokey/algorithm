package programmers.practice.lv2;

import java.util.Stack;

public class AfterBiggerNumber_154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }
        Stack<Number> numberStack = new Stack<>();
        numberStack.push(new Number(numbers[0], 0));
        for (int i = 1; i < numbers.length; i++) {
            Number inputNumber = new Number(numbers[i], i);
            while (!numberStack.isEmpty() && numberStack.peek().compare(inputNumber)) {
                Number number = numberStack.pop();
                answer[number.index] = numbers[i];
            }
            numberStack.push(inputNumber);
        }
        return answer;
    }

    public class Number {
        int number;
        int index;

        public Number(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public boolean compare(Number input) {
            return this.number - input.number < 0 ? true : false;
        }
    }
}
