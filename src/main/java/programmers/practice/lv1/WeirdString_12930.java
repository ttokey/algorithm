package programmers.practice.lv1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdString_12930 {
    public String solution(String s) {
        Pattern p = Pattern.compile("\\b\\w+");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String toReplace = m.group();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < toReplace.length(); i++) {
                String input = toReplace.substring(i, i + 1);
                sb.append(i % 2 == 0 ? input.toUpperCase() : input.toLowerCase());
            }
            s = s.replaceAll("\\b" + toReplace, sb.toString());
        }
        return s;
    }
}
