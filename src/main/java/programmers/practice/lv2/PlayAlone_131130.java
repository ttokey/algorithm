package programmers.practice.lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayAlone_131130 {
    public int solution(int[] cards) {
        List<Integer> groupMultiple = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != 0) {
                groupMultiple.add(makeGroup(cards, i));
            }
        }
        if (groupMultiple.size() <= 1) {
            return 0;
        }
        groupMultiple.sort(Comparator.naturalOrder());
        return groupMultiple.get(groupMultiple.size() - 1) * groupMultiple.get(groupMultiple.size() - 2);
    }

    public int makeGroup(int[] cards, int index) {
        int count = 0;
        while (cards[index] != 0) {
            int temp = cards[index];
            cards[index] = 0;
            index = temp - 1;
            count++;
        }
        return count;
    }
}
