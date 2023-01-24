package programmers.practice.lv1;

public class CalculateShortfall_82612 {
    public long solution(int price, int money, int count) {
        long answer = countPrice(price, count) - money;
        return answer < 0 ? 0 : answer;
    }

    public long countPrice(int price, int count) {
        long totalCount = (1 + count) * count / 2;
        return price * totalCount;
    }
}
