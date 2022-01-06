package programmers.skillCheck;

public class Level2_2 {
    public int solution(int n) {
        int original = getBinaryOne(n);
        int targetNum = n + 1;
        while (getBinaryOne(targetNum) != original) {
            targetNum++;
        }
        return targetNum;
    }

    public int getBinaryOne(int number) {
        String s_num = Integer.toBinaryString(number);
        int count = 0;
        for (int i = 0; i < s_num.length(); i++) {
            if (s_num.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}
