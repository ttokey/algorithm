package programmers.practice.lv2;

public class RightBracket {
    private final static char LEFT_BRACKET = '(';
    private final static char RIGHT_BRACKET = ')';

    boolean solution(String s) {
        Bracket bracket = new Bracket();
        for (char input : s.toCharArray()) {
            if (input == LEFT_BRACKET) {
                bracket.inputLeft();
            } else {
                if (!bracket.inputRight()) {
                    return false;
                }
            }
        }
        return bracket.isEnd();
    }

    public class Bracket {
        private int leftBracket = 0;

        public void inputLeft() {
            this.leftBracket++;
        }

        public boolean inputRight() {
            if (leftBracket > 0) {
                leftBracket--;
                return true;
            }
            return false;
        }

        public boolean isEnd() {
            return leftBracket == 0;
        }
    }
}
