package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberCard_135807 {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        return Math.max(calc(arrayA, arrayB), calc(arrayB, arrayA));
    }

    public int calc(int[] arrayA, int[] arrayB) {
        List<Integer> firstFactorList = new ArrayList<>();
        List<Integer> commonFactorList = new ArrayList<>();

        for (int i = 2; i <= arrayA[0]; i++) {
            if (arrayA[0] % i == 0) {
                firstFactorList.add(i);
            }
        }

        for (int factor : firstFactorList) {
            if (isCommonFactor(arrayA, factor)) {
                commonFactorList.add(factor);
            }
        }

        for (int i = commonFactorList.size() - 1; i >= 0; i--) {
            if (isNotCommonFactor(arrayB, commonFactorList.get(i))) {
                return commonFactorList.get(i);
            }
        }
        return 0;
    }

    public boolean isCommonFactor(int[] array, int input) {
        for (int check : array) {
            if (check % input != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotCommonFactor(int[] array, int input) {
        for (int check : array) {
            if (check % input == 0) {
                return false;
            }
        }
        return true;
    }
}
