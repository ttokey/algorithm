package programmers.practice.lv2;

public class MagicElevator_148653 {
    public int solution(int storey) {
        int answer = (int) dp(storey, 0);
        return answer;
    }

    public long dp(long storey, long count) {
        if (storey <= 5) {
            return storey + count;
        }
        long digit = storey % 10;
        return Math.min(dp((storey - digit) / 10, count + digit),
                dp((storey + (10 - digit)) / 10, count + (10 - digit)));
    }
}
