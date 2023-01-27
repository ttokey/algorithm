package programmers.practice.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoHighesLowesRanking_77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int countMatching = countMatching(toList(lottos), toList(win_nums));
        int countZero = countZero(toList(lottos));
        int[] answer = {7 - countMatching - countZero, 7 - countMatching};
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 7) {
                answer[i] = 6;
            }
        }
        return answer;
    }

    public int countMatching(List<Integer> lottos, List<Integer> win_nums) {
        int count = 0;
        for (int i : lottos) {
            if (i != 0 && win_nums.contains(i)) {
                count++;
            }
        }
        return count;
    }

    public int countZero(List<Integer> lottos) {
        int count = 0;
        for (int i : lottos) {
            if (i == 0) {
                count++;
            }
        }
        return count;
    }


    public List<Integer> toList(int[] input) {
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());
    }
}
