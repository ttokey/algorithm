package programmers.practice;

//https://programmers.co.kr/learn/courses/30/lessons/42898

public class WayToSchool {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] puddlesMap = new boolean[m + 1][n + 1];
        double[][] result = new double[m + 1][n + 1];
        for (int[] puddle : puddles) {
            puddlesMap[puddle[0]][puddle[1]] = true;
        }
        result[0][1] = 1;
        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                if (!puddlesMap[i][j]) {
                    result[i][j] = (result[i - 1][j] + result[i][j - 1]) % 1000000007;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return (int) result[m][n] % 1000000007;
    }
}
