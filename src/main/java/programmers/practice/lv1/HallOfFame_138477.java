package programmers.practice.lv1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HallOfFame_138477 {
    public int[] solution(int k, int[] scores) {
        LinkedList<Integer> scoreList = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for (int score : scores) {
            boolean isInput = false;
            for (int i = 0; i < scoreList.size(); i++) {
                if (score > scoreList.get(i)) {
                    scoreList.add(i, score);
                    isInput = true;
                    break;
                }
            }
            if (!isInput) {
                scoreList.add(score);
            }
            if (scoreList.size() < k) {
                result.add(scoreList.getLast());
            } else {
                result.add(scoreList.get(k - 1));
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
