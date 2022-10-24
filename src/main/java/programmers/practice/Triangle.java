package programmers.practice;

//https://programmers.co.kr/learn/courses/30/lessons/43105

import java.util.Arrays;

public class Triangle {
    public int solution(int[][] triangle) {
        int[][] sumMap = new int[triangle.length][triangle.length + 1];
        sumMap[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            sumMap[i][0] = sumMap[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i + 1; j++) {
                sumMap[i][j] = Math.max(sumMap[i - 1][j - 1], sumMap[i - 1][j]) + triangle[i][j];
            }
        }
        return Arrays.stream(sumMap[triangle.length - 1]).max().getAsInt();
    }
}
