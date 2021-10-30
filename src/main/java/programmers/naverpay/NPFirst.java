package programmers.naverpay;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NPFirst {

    public int solution(String[] id_list, int k) {
        Map<String, Integer> couponMap = new HashMap<>();

        for (String oneDayId : id_list) {
            String[] ids = oneDayId.split(" ");
            Set<String> idSet = new HashSet<>();
            for (String id : ids) {
                idSet.add(id);
            }
            for (String id : idSet) {
                if (couponMap.containsKey(id) && couponMap.get(id) < k) {
                    couponMap.put(id, couponMap.get(id) + 1);
                } else if (!couponMap.containsKey(id)) {
                    couponMap.put(id, 1);
                }
            }
        }

        int answer = 0;
        for (int couponCount : couponMap.values()) {
            answer += couponCount;
        }
        return answer;
    }


}
