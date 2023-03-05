package programmers.practice.lv2;

public class PaintOver_161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for (int wallNum : section) {
            if (wallNum - start >= m) {
                answer++;
                start = wallNum;
            }
        }
        return answer;
    }
}
