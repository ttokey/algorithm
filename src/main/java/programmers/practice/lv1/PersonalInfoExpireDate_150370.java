package programmers.practice.lv1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalInfoExpireDate_150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        LocalDate todayDate = stringToDate(today);
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] splitTerm = term.split(" ");
            termMap.put(splitTerm[0], Integer.valueOf(splitTerm[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacy = privacies[i].split(" ");
            if (todayDate.isAfter(stringToDate(splitPrivacy[0]).plusMonths(termMap.get(splitPrivacy[1])))
                    || todayDate.isEqual(stringToDate(splitPrivacy[0]).plusMonths(termMap.get(splitPrivacy[1])))) {
                result.add(i + 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public LocalDate stringToDate(String input) {
        int[] inputArray = Arrays.stream(input.split("\\.")).mapToInt(s -> Integer.valueOf(s)).toArray();
        return LocalDate.of(inputArray[0], inputArray[1], inputArray[2]);
    }
}
