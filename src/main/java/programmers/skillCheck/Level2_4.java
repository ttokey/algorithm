package programmers.skillCheck;

import java.util.HashSet;
import java.util.Set;

public class Level2_4 {
    public int solution(String numbers) {
        MakeNum makeNum = new MakeNum(numbers);
        makeNum.makeAllNum();
        int answer = makeNum.countPrime();
        return answer;
    }

    public class MakeNum {

        Set<Integer> numbers;
        char[] c_numbers;
        boolean[] b_numbers;

        public MakeNum(String numbers) {
            this.numbers = new HashSet<>();
            this.c_numbers = numbers.toCharArray();
            this.b_numbers = new boolean[c_numbers.length];
        }

        public void makeAllNum() {
            for (int i = 0; i < c_numbers.length; i++) {
                find(i, "0");
            }
        }

        public void find(int index, String s_num) {
            numbers.add(Integer.parseInt(s_num));

            if (isFinished()) {
                return;
            }

            for (int i = 0; i < c_numbers.length; i++) {
                if (!b_numbers[i]) {
                    b_numbers[i] = true;
                    find(i, s_num + String.valueOf(c_numbers[i]));
                    b_numbers[i] = false;
                }
            }
        }

        public int countPrime() {
            int count = 0;
            for (Integer num : numbers) {
                if (isPrime(num)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isPrime(int num) {
            if (num <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private boolean isFinished() {
            for (boolean b : b_numbers) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }
    }


}
