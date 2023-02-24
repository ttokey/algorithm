package programmers.practice.lv1;

public class PAndYCountAtString_12916 {
    boolean solution(String s) {
        String[] arr = s.toUpperCase().split("");
        int count = 0;
        for (String str : arr) {
            if (str.equals("P")) {
                count++;
            } else if (str.equals("Y")) {
                count--;
            }
        }
        return count == 0;
    }
}
