package programmers.practice.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tuple_64065 {
    public int[] solution(String s) {
        List<String> numberArrayList = Arrays.stream(s.split("\\{|\\}")).filter(str -> !(str.isEmpty() || str.equals(","))).collect(Collectors.toList());
        Map<Integer, Integer> numberOrderMap = new HashMap<>();
        for (String numberArrayString : numberArrayList) {
            int[] numberArray = Arrays.stream(numberArrayString.split(",")).mapToInt(str -> Integer.valueOf(str)).toArray();
            for (int number : numberArray) {
                numberOrderMap.merge(number, numberArray.length, Math::min);
            }
        }
        int[] answer = new int[numberArrayList.size()];
        for (Integer key : numberOrderMap.keySet()) {
            answer[numberOrderMap.get(key) - 1] = key;
        }
        return answer;
    }
}
