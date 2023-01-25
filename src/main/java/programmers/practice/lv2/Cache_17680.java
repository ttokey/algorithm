package programmers.practice.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Cache_17680 {
    int cacheHit = 1;
    int cacheMiss = 5;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.contains(city)) {
                answer += cacheHit;
                cache.remove(city);
            } else {
                if (cache.size() >= cacheSize) {
                    cache.poll();
                }
                answer += cacheMiss;
            }
            cache.add(city);
        }
        return answer;
    }
}
