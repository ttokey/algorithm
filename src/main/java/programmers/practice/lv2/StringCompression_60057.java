package programmers.practice.lv2;

public class StringCompression_60057 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length(); i++) {
            answer = Math.min(answer, getLength(s, i));
        }
        return answer;
    }

    public int getLength(String s, int size) {
        StringBuilder sb = new StringBuilder();
        String point = s.substring(0, size);
        int count = 1;
        String compare = "";
        for (int i = size; i < s.length(); i += size) {
            if (i + size >= s.length()) {
                compare = s.substring(i);
            } else {
                compare = s.substring(i, i + size);
            }
            if (!point.equals(compare)) {
                if (count <= 1) {
                    sb.append(point);
                } else {
                    sb.append(count).append(point);
                }
                point = compare;
                count = 1;
            } else {
                count++;
            }
        }
        if (count <= 1) {
            sb.append(point);
        } else {
            sb.append(count).append(point);
        }
        return sb.length();
    }
}
