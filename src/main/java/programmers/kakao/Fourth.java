package programmers.kakao;

import java.util.Arrays;

public class Fourth {
    int[] a = new int[11];
    int[] b = new int[11];

    int maxDiff = 0;


    public int[] solution(int n, int[] info) {
        a = info;

        int[] infoB = new int[11];
        for (int i = 0; i < b.length; i++) {
            b[i] = 0;
            infoB[i] = 0;
        }
        for (int i = 0; i < 11; i++) {
            dfs(infoB, i, n);
        }
        if (maxDiff == 0) {
            return new int[]{-1};
        }

        return b;
    }

    public void dfs(int[] infoB, int index, int n) {
        int countB = Arrays.stream(infoB).sum();
        if (countB > n) {
            return;
        }
        if (countB == n) {
            if (maxDiff < getScore(infoB)) {
                maxDiff = getScore(infoB);
                for (int i = 0; i < infoB.length; i++) {
                    b[i] = infoB[i];
                }

            }
            if (maxDiff == getScore(infoB)) {
                maxDiff = getScore(infoB);
                findScore(infoB);
            }

            return;
        }

        for (int i = index; i < 11; i++) {
            if (n - sumCount(infoB) < a[i] + 1) {
                infoB[i] = n - sumCount(infoB);
            } else {
                infoB[i] = a[i] + 1;
            }

            dfs(infoB, index + 1, n);
            infoB[i] = 0;
        }
    }

    public int sumCount(int[] input) {
        return Arrays.stream(input).sum();
    }

    public void findScore(int[] infoB) {
        boolean isInfoB = false;

        for (int i = 10; i >= 0; i--) {
            if (infoB[i] > b[i]) {
                isInfoB = true;
                break;
            } else if (infoB[i] < b[i]) {
                break;
            }
        }
        if (isInfoB) {
            for (int i = 0; i < infoB.length; i++) {
                b[i] = infoB[i];
            }
        }
    }


    public int getScore(int[] info) {
        int count = 0;
        for (int i = 0; i < info.length; i++) {
            if (info[i] != 0 || a[i] != 0) {
                if (info[i] > a[i]) {
                    count += (10 - i);
                } else {
                    count -= (10 - i);
                }
            }
        }
        return count;
    }


}
