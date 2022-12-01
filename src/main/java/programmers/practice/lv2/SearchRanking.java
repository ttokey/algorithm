package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchRanking {
    public int[] solution(String[] info, String[] query) {
        int[] answer = search(mapInfoes(info), toDBQuery(query));
        return answer;
    }

    public int[] search(Map<String, List<Integer>> mapInfoes, String[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            String[] getQuery = makeQuery(queries[i]);
            Integer needScore = Integer.parseInt(queries[i][4]);
            for (String query : getQuery) {
                if (mapInfoes.containsKey(query)) {
                    int index = binarySearch(mapInfoes.get(query), needScore);
                    count += mapInfoes.get(query).size() - index;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int binarySearch(List<Integer> input, int target) {
        int start = 0;
        int end = input.size() - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (input.get(mid) == target) {
                return mid;
            } else if (input.get(mid) > target) {
                if (mid - 1 < 0) {
                    return 0;
                } else if (input.get(mid - 1) < target) {
                    return mid;
                }
                end = mid - 1;
            } else {
                if (mid + 1 > input.size() - 1) {
                    return input.size();
                } else if (input.get(mid + 1) > target) {
                    return mid + 1;
                }
                start = mid + 1;
            }
        }
        return mid;
    }


    public String[] makeQuery(String[] query) {
        Queue<String> q1 = new LinkedList<>();
        if (query[0].equals("-")) {
            q1.add("cpp");
            q1.add("java");
            q1.add("python");
        } else {
            q1.add(query[0]);
        }

        Queue<String> q2 = new LinkedList<>();
        if (query[1].equals("-")) {
            while (!q1.isEmpty()) {
                String s = q1.poll();
                q2.add(s + "backend");
                q2.add(s + "frontend");
            }
        } else {
            while (!q1.isEmpty()) {
                String s = q1.poll();
                q2.add(s + query[1]);
            }
        }
        Queue<String> q3 = new LinkedList<>();
        if (query[2].equals("-")) {
            while (!q2.isEmpty()) {
                String s = q2.poll();
                q3.add(s + "junior");
                q3.add(s + "senior");
            }
        } else {
            while (!q2.isEmpty()) {
                String s = q2.poll();
                q3.add(s + query[2]);
            }
        }

        Queue<String> q4 = new LinkedList<>();
        if (query[3].equals("-")) {
            while (!q3.isEmpty()) {
                String s = q3.poll();
                q4.add(s + "chicken");
                q4.add(s + "pizza");
            }
        } else {
            while (!q3.isEmpty()) {
                String s = q3.poll();
                q4.add(s + query[3]);
            }
        }
        return q4.toArray(new String[0]);
    }

    public String[][] toDBInfoes(String[] infoes) {
        String[][] result = new String[infoes.length][5];
        for (int i = 0; i < infoes.length; i++) {
            result[i] = infoes[i].split(" ");
        }
        return result;
    }

    public Map<String, List<Integer>> mapInfoes(String[] infoes) {

        Map<String, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < infoes.length; i++) {
            String[] splitInfoes = infoes[i].split(" ");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                sb.append(splitInfoes[j]);
            }
            Integer score = Integer.parseInt(splitInfoes[4]);
            result.merge(sb.toString(), Arrays.asList(score), (v1, v2) -> Stream.concat(v1.stream(), Arrays.asList(score).stream()).collect(Collectors.toList()));
        }
        for (String key : result.keySet()) {
            result.get(key).sort(Comparator.naturalOrder());
        }
        return result;
    }

    public String[][] toDBQuery(String[] queries) {
        String[][] result = new String[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i].split(" ");
            query = removeAnd(query);
            result[i] = query;
        }
        return result;
    }

    public String[] removeAnd(String[] inputs) {
        List<String> result = new ArrayList<>();
        for (String input : inputs) {
            if (!input.equals("and")) {
                result.add(input);
            }
        }
        return result.toArray(new String[0]);
    }
}
