package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi_12946 {
    List<Integer[]> hanoi = new ArrayList<>();

    public int[][] solution(int n) {
        dp(n, 1, 2, 3);
        int[][] result = new int[hanoi.size()][2];
        for (int i = 0; i < hanoi.size(); i++) {
            int[] input = new int[]{hanoi.get(i)[0], hanoi.get(i)[1]};
            result[i] = input;
        }
        return result;
    }

    public void dp(int n, int start, int mid, int end) {
        if (n == 1) {
            hanoi.add(new Integer[]{start, end});
            return;
        }

        dp(n - 1, start, end, mid);
        dp(1, start, mid, end);
        dp(n - 1, mid, start, end);
    }
}
