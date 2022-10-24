package programmers.practice;

//https://programmers.co.kr/learn/courses/30/lessons/42576


import java.util.HashMap;
import java.util.Map;

public class UnsuccessfulRunner {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = toMap(participant);
        participantMap = minusCompletion(participantMap, completion);
        String answer = getAnswer(participantMap);
        return answer;
    }

    public String getAnswer(Map<String, Integer> map) {
        String answer = "";
        for (String person : map.keySet()) {
            if (map.get(person) > 0) {
                answer = person;
                break;
            }
        }
        return answer;
    }

    public Map<String, Integer> minusCompletion(Map<String, Integer> participantMap, String[] completions) {
        for (String completion : completions) {
            if (participantMap.get(completion) > 0) {
                participantMap.put(completion, participantMap.get(completion) - 1);
            }
        }
        return participantMap;
    }

    public Map<String, Integer> toMap(String[] participants) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String participant : participants) {
            if (participantMap.containsKey(participant)) {
                participantMap.put(participant, participantMap.get(participant) + 1);
            } else {
                participantMap.put(participant, 1);
            }
        }
        return participantMap;
    }


}
