package programmers.practice.lv2;

public class TriangleSnail_68645 {
    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];
        int[][] direction = {{1, 0}, {0, 1}, {-1, -1}};
        int[][] snail = new int[n][n];
        int x = 0;
        int y = -1;
        int input = 0;
        int dir = 0;
        int distance = n;
        while (distance != 0) {
            for (int i = 0; i < distance; i++) {
                input++;
                y += direction[dir][0];
                x += direction[dir][1];
                snail[y][x] = input;
            }
            distance--;
            dir = (dir + 1) % 3;
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = snail[i][j];
                index++;
            }
        }
        return answer;
    }
}
