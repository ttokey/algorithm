package programmers.kmong.function;

public class calculate2 {

    public int calculateProfits(int completedAmount) {
        int profit = completedAmount;
        int 수수료 = 0;
        int target = completedAmount;

        //section3
        if (1_000_001 <= completedAmount) {
            target = completedAmount - 1_000_000;
            수수료 = target * 5 / 100;
            profit -= 수수료;
        }

        //section2
        if (500_001 <= completedAmount) {
            target = Math.min(completedAmount, 1_000_000) - 500_000;
            수수료 = target * 10 / 100;
            profit -= 수수료;
        }

        //section1
        if (1 <= completedAmount) {
            target = Math.min(completedAmount, 500_000);
            수수료 = target * 20 / 100;
            profit -= 수수료;
        }

        return profit;
    }
}
