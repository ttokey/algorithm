package programmers.skillCheck;

public class Level1_1 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (isEven(i)) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }


    public boolean isEven(int number) {
        int rootNumber = (int) Math.sqrt(number);
        return rootNumber * rootNumber == number ? false : true;
    }
}
