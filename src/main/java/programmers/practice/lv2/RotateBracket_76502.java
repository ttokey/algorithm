package programmers.practice.lv2;

import java.util.Arrays;
import java.util.Stack;

public class RotateBracket_76502 {
    public int solution(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String checkString = s.substring(i) + s.substring(0, i);
            if (isCorrectString(checkString)) {
                count++;
            }
        }
        return count;
    }

    public boolean isCorrectString(String checkString) {
        Stack<Bracket> bracketStack = new Stack<>();
        for (int i = 0; i < checkString.length(); i++) {
            Bracket bracket = Bracket.of(checkString.charAt(i));
            if (bracket.isOpen()) {
                bracketStack.add(bracket);
            } else if (bracketStack.isEmpty() || !bracketStack.pop().isCoupled(bracket)) {
                return false;
            }
        }
        if (bracketStack.isEmpty()) {
            return true;
        }
        return false;
    }

    public enum Bracket {
        PARENTHESES_OPEN('(', 0, true),
        PARENTHESES_CLOSE(')', 0, false),
        BRACES_OPEN('{', 1, true),
        BRACES_CLOSE('}', 1, false),
        SQUARE_OPEN('[', 2, true),
        SQUARE_CLOSE(']', 2, false),
        ;

        private char bracket;
        private int number;
        private boolean isOpen;

        Bracket(char bracket, int number, boolean isOpen) {
            this.bracket = bracket;
            this.number = number;
            this.isOpen = isOpen;
        }

        public static Bracket of(char bracket) {
            return Arrays.stream(values()).filter(b -> b.bracket == bracket).findFirst().get();
        }

        public boolean isOpen() {
            return isOpen;
        }

        public boolean isCoupled(Bracket input) {
            return this.number == input.number;
        }
    }
}
