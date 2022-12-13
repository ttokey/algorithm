package programmers.practice.lv1;

public class DivideString_140108 {
    public int solution(String s) {
        char firstChar = s.charAt(0);
        int firstCount = 0;
        int secondCount = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (firstCount == secondCount) {
                result++;
                firstCount = 0;
                secondCount = 0;
                firstChar = s.charAt(i);
            }
            if (s.charAt(i) == firstChar) {
                firstCount++;
            } else {
                secondCount++;
            }
        }
        return result;
    }
}
