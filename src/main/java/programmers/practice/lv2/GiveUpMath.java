package programmers.practice.lv2;

// https://programmers.co.kr/learn/courses/30/lessons/42840
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5,      1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5,      2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,     3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

//answers	return
//[1,2,3,4,5]	[1]
//[1,3,2,4,2]	[1,2,3]

//제한 조건
//        시험은 최대 10,000 문제로 구성되어있습니다.
//        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GiveUpMath {
    public int[] solution(int[] answers) {
        int[][] getAnswer = makePersonAnswer(answers.length);
        return getAnswer(getAnswer, answers);
    }

    public int[] getAnswer(int[][] personalAnswer, int[] answers) {
        List<Integer> maxAnswer = new ArrayList<>();
        int maxCount = -1;
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < answers.length; j++) {
                if (personalAnswer[i][j] == answers[j]) {
                    count++;
                }
            }
            if (maxCount == count) {
                maxAnswer.add(i + 1);
            } else if (maxCount <= count) {
                maxCount = count;
                maxAnswer = new ArrayList<>();
                maxAnswer.add(i + 1);
            }
        }
        maxAnswer.sort(Comparator.naturalOrder());
        return maxAnswer.stream()
                .mapToInt(i -> i)
                .toArray();
    }

    public int[][] makePersonAnswer(int length) {
        List<List<Integer>> ruleAnswer = new ArrayList<>();
        ruleAnswer.add(Arrays.asList(1, 2, 3, 4, 5));
        ruleAnswer.add(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        ruleAnswer.add(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        int[][] result = new int[3][length];

        for (int i = 0; i < ruleAnswer.size(); i++) {
            for (int j = 0; j < length; j++) {
                result[i][j] = ruleAnswer.get(i).get(j % ruleAnswer.get(i).size());
            }
        }
        return result;
    }


}
