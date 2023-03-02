package programmers.practice.lv2;

public class EatTheGround_12913 {
    int solution(int[][] land) {
        int[][] sum = new int[land.length][4];
        for (int j = 0; j < 4; j++) {
            sum[0][j] = land[0][j];
        }
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        max = Math.max(sum[i - 1][k], max);
                    }
                }
                sum[i][j] = land[i][j] + max;
            }
        }
        int result = 0;
        for (int j = 0; j < 4; j++) {
            result = Math.max(sum[sum.length - 1][j], result);
        }
        return result;
    }
}
