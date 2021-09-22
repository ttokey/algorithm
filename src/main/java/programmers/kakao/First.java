package programmers.kakao;

import java.util.*;

public class First {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set> makeReport = makeReport(id_list, report);
        Set<String> countReport = countReport(makeReport, k);
        int[] answer = getResult(id_list, makeReport, countReport);
        return answer;
    }

    public int[] getResult(String[] id_list, Map<String, Set> makeReport, Set<String> countReport) {
        int[] result = new int[id_list.length];
        for (int i = 0; i < result.length; i++) {
            int count = 0;
            Set<String> getReportList = makeReport.get(id_list[i]);
            for (String s : getReportList) {
                if (countReport.contains(s)) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public Set<String> countReport(Map<String, Set> makeReport, int k) {
        Map<String, Integer> result = new HashMap<>();
        for (Set set : makeReport.values()) {
            for (Object s : set) {
                result.merge((String) s, 1, (v1, v2) -> v1 + 1);
            }
        }
        List<String> toRemove = new ArrayList<>();
        for (String s : result.keySet()) {
            if (result.get(s) < k) {
                toRemove.add(s);
            }
        }
        for (String s : toRemove) {
            result.remove(s);
        }
        return result.keySet();
    }

    public Map<String, Set> makeReport(String[] id_list, String[] report) {
        Map<String, Set> result = new HashMap<>();
        for (String id : id_list) {
            result.put(id, new HashSet());
        }
        for (String s : report) {
            String[] splitS = s.split(" ");
            Set set = result.get(splitS[0]);
            set.add(splitS[1]);
            result.put(splitS[0], set);
        }
        return result;
    }
}
