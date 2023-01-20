package programmers.practice.lv1;

public class Trio_131705 {
    int answer = 0;
    boolean[] visit;
    int[] numbers;

    public int solution(int[] number) {
        numbers = number;
        visit = new boolean[number.length];
        for (int i = 0; i < number.length; i++) {
            visit[i] = true;
            dfs(1, i);
            visit[i] = false;
        }

        return answer;
    }

    public void dfs(int count, int index) {
        if (count == 3) {
            if (isSumZero()) {
                answer++;
            }
            return;
        }

        for (int i = index + 1; i < visit.length; i++) {
            visit[i] = true;
            dfs(count + 1, i);
            visit[i] = false;
        }
    }

    public boolean isSumZero() {
        int sum = 0;
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                sum += numbers[i];
            }
        }
        return sum == 0;
    }
}
