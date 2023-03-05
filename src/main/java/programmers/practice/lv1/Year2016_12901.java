package programmers.practice.lv1;

public class Year2016_12901 {
    public String solution(int a, int b) {
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] monthMaxDay = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = 0;
        for (int i = 0; i <= a - 1; i++) {
            day += monthMaxDay[i];
        }
        day += b;
        return dayOfWeek[(day - 1) % 7];
    }
}
