package programmers.practice.lv1;

public class ColaProblem_132267 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = n;
        while (cola >= a) {
            int getCola = cola / a;
            cola -= getCola * a;
            answer += getCola * b;
            cola += getCola * b;
        }
        return answer;
    }
}
