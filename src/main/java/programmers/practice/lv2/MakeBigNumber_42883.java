package programmers.practice.lv2;

public class MakeBigNumber_42883 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        while (k != 0 && k < number.length()) {
            int maxNum = -1;
            int maxIndex = -1;
            boolean isNine = false;
            for (int i = 0; i <= k && i < number.length() && !isNine; i++) {
                int num = Integer.parseInt(number.substring(i, i + 1));
                if (maxNum < num) {
                    maxNum = num;
                    maxIndex = i;
                }
                if (num == 9) {
                    maxNum = num;
                    maxIndex = i;
                    isNine = true;
                }
            }
            sb.append(number.substring(maxIndex, maxIndex + 1));
            k -= maxIndex;
            number = number.substring(maxIndex + 1);
        }
        if (k == 0) {
            sb.append(number);
        }
        return sb.toString();
    }
}
