package programmers.practice.lv2;

public class PracticeBilliard_169198 {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            answer[i] = getMinDistance(startX, startY, balls[i][0], balls[i][1], m, n);
        }
        return answer;
    }

    public int getMinDistance(int startX, int startY, int targetX, int targetY, int m, int n) {
        int result = Integer.MAX_VALUE;
        if (startY != targetY || startX < targetX) {
            result = Math.min(result, getDistance(startX, startY, -targetX, targetY));
        }
        if (startY != targetY || startX > targetX) {
            result = Math.min(result, getDistance(startX, startY, 2 * m - targetX, targetY));
        }

        if (startX != targetX || startY < targetY) {
            result = Math.min(result, getDistance(startX, startY, targetX, -targetY));
        }
        if (startX != targetX || startY > targetY) {
            result = Math.min(result, getDistance(startX, startY, targetX, 2 * n - targetY));
        }
        return result;
    }

    public int getDistance(int startX, int startY, int targetX, int targetY) {
        return (int) Math.pow(targetX - startX, 2) + (int) Math.pow(targetY - startY, 2);
    }
}
