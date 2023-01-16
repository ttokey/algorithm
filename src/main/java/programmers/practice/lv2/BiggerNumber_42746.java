package programmers.practice.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BiggerNumber_42746 {
    public String solution(int[] numbers) {
        List<String> numberList = Arrays.stream(numbers).mapToObj(i -> String.valueOf(i)).collect(Collectors.toList());
        numberList.sort((a, b) -> compare(a, b));
        if (numberList.get(0).equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String number : numberList) {
            sb.append(number);
        }
        return sb.toString();
    }

    public int compare(String num1String, String num2String) {
        for (int i = 0; i < num1String.length() && i < num2String.length(); i++) {
            int num1Index = Integer.valueOf(num1String.substring(i, i + 1));
            int num2Index = Integer.valueOf(num2String.substring(i, i + 1));
            if (num1Index > num2Index) {
                return -1;
            } else if (num1Index < num2Index) {
                return 1;
            }
        }
        if (num1String.length() > num2String.length()) {
            return compare(num1String.substring(num2String.length()), num2String);
        } else if (num1String.length() < num2String.length()) {
            return compare(num1String, num2String.substring(num1String.length()));
        }
        return 0;
    }
}
