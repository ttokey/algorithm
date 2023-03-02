package programmers.practice.lv2;

public class NumberBlock_12923 {
    public int[] solution(long begin, long end) {
        int[] result = new int[(int) (end - begin + 1)];
        int index = 0;
        for (long i = begin; i <= end; i++) {
            result[index] = getBlock(i);
            index++;
        }
        return result;
    }

    public int getBlock(long input) {
        int max = 1;
        if (input == 1) {
            return 0;
        }
        long sqrt = (long) Math.sqrt(input);
        for (long i = 2; i <= sqrt; i++) {
            if (input % i == 0) {
                if (input / i <= 10000000) {
                    return (int) (input / i);
                } else {
                    max = (int) i;
                }
            }
        }
        return max;
    }
}
