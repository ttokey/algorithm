package programmers.practice.lv2;

public class MultipleMatrix_12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                long input = 0;
                for (int k = 0; k < arr1[i].length; k++) {
                    input += (long) arr1[i][k] * (long) arr2[k][j];
                }
                answer[i][j] = (int) input;
            }
        }
        return answer;
    }
}
