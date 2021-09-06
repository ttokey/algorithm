package programmers;


//https://programmers.co.kr/learn/courses/30/lessons/42748

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//array	commands	return
//[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
public class GetK {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < commands.length; i++) {
            List<Integer> parsedList = parseListAndSort(array, commands[i][0], commands[i][1]);
            answer.add(parsedList.get(commands[i][2] - 1));
        }
        return answer.stream()
                .mapToInt(v -> v)
                .toArray();
    }

    public List<Integer> parseListAndSort(int[] array, int from, int to) {
        List<Integer> result = new ArrayList<>();
        for (int i = from - 1; i < to; i++) {
            result.add(array[i]);
        }
        result.sort(Comparator.naturalOrder());
        return result;
    }
}
