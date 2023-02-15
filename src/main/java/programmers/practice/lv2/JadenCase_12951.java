package programmers.practice.lv2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JadenCase_12951 {
    public String solution(String s) {
        Matcher m = Pattern.compile("\\b([\\w])([\\w]*)").matcher(s);
        while (m.find()) {
            s = s.replaceAll("\\b" + m.group(), m.group(1).toUpperCase() + m.group(2).toLowerCase());
        }
        return s;
    }

    public static void main(String[] args) {
        JadenCase_12951 jadenCase_12951 = new JadenCase_12951();
        System.out.println(jadenCase_12951.solution("aaaaa aaa"));
    }
}
