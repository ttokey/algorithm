package programmers.practice.lv1;

import java.util.*;

public class ReportResult_92334 {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String report : reports) {
            String[] reportArray = report.split(" ");
            Set<String> value = reportMap.getOrDefault(reportArray[1], new HashSet<String>());
            value.add(reportArray[0]);
            reportMap.put(reportArray[1], value);
        }
        List<String> mailList = new ArrayList<>();
        for (Set<String> value : reportMap.values()) {
            if (value.size() >= k) {
                mailList.addAll(value);
            }
        }
        Map<String, Integer> mailMap = new HashMap<>();
        for (String target : mailList) {
            mailMap.merge(target, 1, Integer::sum);
        }
        return Arrays.stream(id_list).mapToInt(s -> mailMap.getOrDefault(s, 0)).toArray();
    }
}
