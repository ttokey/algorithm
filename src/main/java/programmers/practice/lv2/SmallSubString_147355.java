package programmers.practice.lv2;

public class SmallSubString_147355 {
    public int solution(String t, String p) {
        int answer = 0;
        int intP = Integer.valueOf(p);
        for (int i = 0; i < t.length() - p.length(); i++) {
            int intT = Integer.valueOf(t.substring(i, i + p.length()));
            if (intT <= intP) {
                answer++;
            }
        }
        return answer;
    }
}
