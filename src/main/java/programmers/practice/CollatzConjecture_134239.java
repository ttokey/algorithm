package programmers.practice;

import java.util.ArrayList;
import java.util.List;

public class CollatzConjecture_134239 {
    public double[] solution(int k, int[][] ranges) {
        Collatz collatz = new Collatz(k);
        return collatz.getAreas(ranges);
    }

    public class Collatz {
        private List<Integer> height;
        private List<Double> area;

        public Collatz(int k) {
            this.height = new ArrayList<>();
            this.area = new ArrayList<>();
            height.add(k);
            int l;
            while (k > 1) {
                l = k;
                k = calcHeight(k);
                height.add(k);
                area.add(calcArea(l, k));
            }
        }

        public double[] getAreas(int[][] ranges) {
            double[] result = new double[ranges.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = getArea(ranges[i][0], ranges[i][1]);
            }
            return result;
        }

        private Double getArea(int start, int end) {
            Double result = 0.0;
            if (start > area.size() + end) {
                return -1.0;
            }
            for (int i = start; i < area.size() + end; i++) {
                result += area.get(i);
            }
            return result;
        }

        private int calcHeight(int k) {
            if ((k & 1) == 0) {
                return k / 2;
            } else {
                return k * 3 + 1;
            }
        }

        private double calcArea(int n, int m) {
            return (n + m + 0.0) / 2;
        }
    }
}
