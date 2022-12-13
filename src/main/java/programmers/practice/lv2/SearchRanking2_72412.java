package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchRanking2_72412 {
    public int[] solution(String[] infos, String[] queries) {
        List<Integer> result = new ArrayList<>();
        Cache cache = new Cache();
        cache.addScore(infos);
        for (String queryString : queries) {
            final int score = Integer.valueOf(queryString.split(" and | ")[4]);
            List<String> queryList = getQueryList(queryString);
            int temp = 0;
            for (String query : queryList) {
                temp += cache.getScore(query, score);
            }
            result.add(temp);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public List<String> getQueryList(String query) {
        String[] splitQuery = query.split(" and | ");
        String[][] queryArray = {{"cpp", "java", "python"},
                {"backend", "frontend"},
                {"junior", "senior"},
                {"chicken", "pizza"}};
        List<List<String>> queryList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<String> input = new ArrayList<>();
            if (splitQuery[i].equals("-")) {
                input.addAll(Arrays.asList(queryArray[i]));
            } else {
                input.add(splitQuery[i]);
            }
            queryList.add(input);
        }
        for (int language = 0; language < queryList.get(0).size(); language++) {
            for (int job = 0; job < queryList.get(1).size(); job++) {
                for (int career = 0; career < queryList.get(2).size(); career++) {
                    for (int food = 0; food < queryList.get(3).size(); food++) {
                        StringBuilder sb = new StringBuilder()
                                .append(queryList.get(0).get(language))
                                .append(queryList.get(1).get(job))
                                .append(queryList.get(2).get(career))
                                .append(queryList.get(3).get(food));
                        result.add(sb.toString());
                    }
                }
            }
        }
        return result;
    }

    public class Cache {
        Map<String, List<Integer>> cache = new HashMap<>();

        public Cache() {
            String[][] queryString = {{"cpp", "java", "python"},
                    {"backend", "frontend"},
                    {"junior", "senior"},
                    {"chicken", "pizza"}};

            for (int language = 0; language < queryString[0].length; language++) {
                for (int job = 0; job < queryString[1].length; job++) {
                    for (int career = 0; career < queryString[2].length; career++) {
                        for (int food = 0; food < queryString[3].length; food++) {
                            StringBuilder sb = new StringBuilder()
                                    .append(queryString[0][language])
                                    .append(queryString[1][job])
                                    .append(queryString[2][career])
                                    .append(queryString[3][food]);
                            cache.put(sb.toString(), new ArrayList<>());
                        }
                    }
                }
            }
        }

        public void addScore(String[] infos) {
            for (String info : infos) {
                String[] splitQuery = info.split(" ");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(splitQuery[i]);
                }
                this.cache.get(sb.toString()).add(Integer.valueOf(splitQuery[4]));
            }
            cache.values()
                    .stream()
                    .forEach(str -> str.sort(Comparator.reverseOrder()));
        }

        public int getScore(String query, int targetScore) {
            List<Integer> temp = cache.get(query);
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) < targetScore) {
                    return i;
                }
            }
            return temp.size();
        }
    }
}
