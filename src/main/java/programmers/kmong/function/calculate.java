package programmers.kmong.function;

import java.util.Arrays;

public class calculate {
    public double calculateProfits(int input) {
        double[] total = new double[3];
        if (input > 1000000) {
            total[2] = (input - 1000000) * 0.95;
            input = 1000000;
        }

        if (input > 500000) {
            total[1] = (input - 500000) * 0.9;
            input = 500000;
        }

        total[0] = input * 0.8;

        return Arrays.stream(total).sum();
    }
}
