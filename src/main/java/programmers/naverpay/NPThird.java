package programmers.naverpay;

import java.util.*;

public class NPThird {
    public String[] solution(String[] logs) {
        Map<String, Map> scoreMap = new HashMap<>();
        for (String log : logs) {
            String[] splitLog = log.split(" ");
            Map<String, String> score = new HashMap<>();
            if (scoreMap.containsKey(splitLog[0])) {
                score = scoreMap.get(splitLog[0]);
                score.put(splitLog[1], splitLog[2]);
            } else {
                score.put(splitLog[1], splitLog[2]);
            }
            scoreMap.put(splitLog[0], score);
        }
        Map<Map, List> reverseScore = new HashMap<>();

        for (String id : scoreMap.keySet()) {
            Map<String, String> score = scoreMap.get(id);
            if (score.size() >= 5) {
                List<String> ids = new ArrayList<>();
                if (reverseScore.containsKey(score)) {
                    ids = reverseScore.get(score);
                }
                ids.add(id);
                reverseScore.put(score, ids);
            }
        }

        List<String> badMan = new ArrayList<>();
        for (List ids : reverseScore.values()) {
            if (ids.size() >= 2) {
                badMan.addAll(ids);
            }
        }
        if (badMan.isEmpty()) {
            badMan.add("None");
        }
        badMan.sort(Comparator.comparing(s -> s));

        return badMan.toArray(new String[0]);
    }

}

