package programmers.practice.lv1;

public class TouchKeyPad_67256 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Hand leftHand = new Hand(3, 0);
        Hand rightHand = new Hand(3, 2);
        for (int number : numbers) {
            if (number % 3 == 2 || number == 0) {
                int leftDistance = leftHand.getDistance(number);
                int rightDistance = rightHand.getDistance(number);
                if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
                    sb.append("L");
                    leftHand.move(number);
                } else {
                    sb.append("R");
                    rightHand.move(number);
                }
            } else if (number % 3 == 1) {
                sb.append("L");
                leftHand.move(number);
            } else {
                sb.append("R");
                rightHand.move(number);
            }
        }
        return sb.toString();
    }

    public class Hand {
        int i;
        int j;

        public Hand(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getDistance(int targetNum) {
            int[] position = getPosition(targetNum);
            return Math.abs(position[0] - i) + Math.abs(position[1] - j);
        }

        public void move(int targetNum) {
            int[] position = getPosition(targetNum);
            this.i = position[0];
            this.j = position[1];
        }

        private int[] getPosition(int targetNum) {
            int[] result = new int[2];
            if (targetNum == 0) {
                result[0] = 3;
                result[1] = 1;
            } else {
                targetNum--;
                result[0] = targetNum / 3;
                result[1] = targetNum % 3;
            }
            return result;
        }
    }
}
