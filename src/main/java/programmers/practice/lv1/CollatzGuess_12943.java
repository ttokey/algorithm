package programmers.practice.lv1;

public class CollatzGuess_12943 {
    public int solution(long num) {
        int answer = 0;
        while (answer <= 500 && num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            answer++;
        }
        return answer <= 500 ? answer : -1;
    }
}
