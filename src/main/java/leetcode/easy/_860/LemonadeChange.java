package leetcode.easy._860;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] dollar = new int[2];
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    dollar[0]++;
                    break;
                case 10:
                    if (dollar[0] > 0) {
                        dollar[0]--;
                    } else {
                        return false;
                    }
                    dollar[1]++;
                    break;
                case 20:
                    if (dollar[1] > 0 && dollar[0] > 0) {
                        dollar[1]--;
                        dollar[0]--;
                    } else if (dollar[0] >= 3) {
                        dollar[0] -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
