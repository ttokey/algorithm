package programmers.skillCheck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Level2_3 {

    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> listCitations = new ArrayList<>();
        for (Integer num : citations) {
            listCitations.add(num);
        }
        listCitations.sort(Comparator.naturalOrder());

        for (int i = listCitations.size(); i > 0; i--) {
            if (listCitations.get(listCitations.size() - i) >= i) {
                answer = i;
                break;
            }
        }
        return answer;
    }


}
