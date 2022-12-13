package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchRanking_72412 {
    public static String LANGUAGE = "language";
    public static String JOB = "job";
    public static String CAREER = "career";
    public static String SOUL_FOOD = "soul food";

    public static String[] KEYS = {LANGUAGE, JOB, CAREER, SOUL_FOOD};


    public int[] solution(String[] info, String[] queries) {
        List<Integer> result = new ArrayList<>();
        SearchDB searchDB = new SearchDB();
        searchDB.inputData(info);
        for (String query : queries) {
            result.add(searchDB.getCount(query));
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    public class SearchDB {
        Map<String, Index> indexes;
        List<Integer> score;
        Map<String, List> cache;

        public SearchDB() {
            indexes = new HashMap<>();
            for (String key : KEYS) {
                indexes.put(key, new Index());
            }
            this.score = new ArrayList<>();
            this.cache = new HashMap<>();
        }

        public void inputData(String[] info) {
            for (int i = 0; i < info.length; i++) {
                String[] splitInfo = info[i].split(" ");
                for (int j = 0; j < 4; j++) {
                    indexes.get(KEYS[j]).addIndex(splitInfo[j], i);
                }
                score.add(Integer.valueOf(splitInfo[4]));
            }
        }

        public int getCount(String query) {
            Map<Integer, Integer> result = new HashMap<>();
            String[] splitQuery = query.split(" ");
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (!splitQuery[i * 2].equals("-")) {
                    List<Integer> indexList = indexes.get(KEYS[i]).getIndex(splitQuery[i * 2]);
                    for (Integer index : indexList) {
                        result.put(index, result.getOrDefault(index, 0) + 1);
                    }
                    count++;
                }
            }
            if (count == 0) {
                return (int) score.stream().filter(i -> i >= Integer.valueOf(splitQuery[7])).count();
            }
            final int finalCount = count;
            StringBuilder cacheKey = new StringBuilder();
            IntStream.range(0, 7).forEach(i -> cacheKey.append(splitQuery[i]));

            List<Integer> resultScores = new ArrayList<>();
            if (cache.containsKey(cacheKey.toString())) {
                resultScores = cache.get(cacheKey.toString());
            } else {
                resultScores = result.entrySet()
                        .stream()
                        .filter(e -> e.getValue() >= finalCount)
                        .map(e -> score.get(e.getKey()))
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
                cache.put(cacheKey.toString(), resultScores);
            }

            int targetScore = Integer.valueOf(splitQuery[7]);
            for (int i = 0; i < resultScores.size(); i++) {
                if (resultScores.get(i) < targetScore) {
                    return i;
                }
            }
            return resultScores.size();
        }
    }

    public class Index {
        Map<String, List<Integer>> index;

        public Index() {
            index = new HashMap<>();
        }

        public void addIndex(String key, Integer value) {
            index.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        public List<Integer> getIndex(String key) {
            return index.getOrDefault(key, new ArrayList<>());
        }
    }
}
