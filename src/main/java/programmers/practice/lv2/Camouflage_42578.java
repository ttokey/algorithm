package programmers.practice.lv2;

import java.util.HashMap;

public class Camouflage_42578 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothMap = new HashMap<>();
        for (String[] clothe : clothes) {
            clothMap.merge(clothe[1], 1, Integer::sum);
        }
        int answer = 1;
        for (int value : clothMap.values()) {
            answer *= (value + 1);
        }
        return answer - 1;
    }
}
