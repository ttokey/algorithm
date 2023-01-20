package programmers.practice.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalityType_11866 {
    public String solution(String[] surveys, int[] choices) {
        Map<String, Integer> surveyMap = new HashMap<>();
        List<String> typeList = Arrays.asList("RT", "CF", "JM", "AN");
        List<String> reverseTypeList = Arrays.asList("TR", "FC", "MJ", "NA");
        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 1; i <= 7; i++) {
            scoreMap.put(i, i - 4);
        }
        for (int i = 0; i < surveys.length; i++) {
            surveyMap.merge(surveys[i], scoreMap.get(choices[i]), Integer::sum);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int score = surveyMap.getOrDefault(typeList.get(i), 0) - surveyMap.getOrDefault(reverseTypeList.get(i), 0);
            if (score <= 0) {
                sb.append(typeList.get(i).charAt(0));
            } else {
                sb.append(typeList.get(i).charAt(1));
            }
        }
        return sb.toString();
    }
}
