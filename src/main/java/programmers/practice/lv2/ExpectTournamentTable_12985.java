package programmers.practice.lv2;

public class ExpectTournamentTable_12985 {
    public int solution(int n, int a, int b) {
        int count = 1;
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (!(b - a == 1 && a % 2 == 1)) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            count++;
        }
        return count;
    }
}
