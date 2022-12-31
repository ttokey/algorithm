package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class OpenChattingRoom_42888 {
    public String[] solution(String[] record) {
        Map<String, String> idMap = new HashMap<>();
        List<String> resultList = new ArrayList<>();
        for (String recordString : record) {
            String[] splitRecord = recordString.split(" ");
            if (splitRecord[0].equals("Enter")) {
                resultList.add(splitRecord[1] + "님이 들어왔습니다.");
                idMap.put(splitRecord[1], splitRecord[2]);
            } else if (splitRecord[0].equals("Leave")) {
                resultList.add(splitRecord[1] + "님이 나갔습니다.");
            } else {
                idMap.put(splitRecord[1], splitRecord[2]);
            }
        }
        String[] answer = resultList.toArray(new String[0]);
        for (int i = 0; i < answer.length; i++) {
            String temp = answer[i];
            String userId = temp.substring(0, temp.indexOf("님이"));
            answer[i] = temp.replace(userId, idMap.get(userId));
        }
        return answer;
    }
}
