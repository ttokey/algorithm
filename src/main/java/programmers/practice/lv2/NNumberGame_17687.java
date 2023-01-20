package programmers.practice.lv2;

public class NNumberGame_17687 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        Integer index = 0;
        while (sb.length() < (t + 1) * m) {
            sb.append(Integer.toString(index, n));
            index++;
        }
        for (int i = 0; i < t; i++) {
            result.append(sb.charAt((p - 1) + (i * m)));
        }
        return result.toString().toUpperCase();
    }
}
