package programmers.practice.lv2;

public class BitUnderTwo_77885 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = findBit(numbers[i]);
        }
        return answer;
    }

    public long findBit(long input) {
        if ((input & 1) == 0) {
            return input + 1;
        }
        int index = 0;
        long temp = input;
        while (temp != 0) {
            if ((temp & 1) == 1) {
                index++;
                temp = temp >> 1;
            } else {
                break;
            }
        }
        return input + (long) Math.pow(2, index - 1);
    }
}
