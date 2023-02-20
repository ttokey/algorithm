package programmers.practice.lv1;

public class DeckOfCards_159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for (String str : goal) {
            if (index1 < cards1.length && cards1[index1].equals(str)) {
                index1++;
            } else if (index2 < cards2.length && cards2[index2].equals(str)) {
                index2++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
