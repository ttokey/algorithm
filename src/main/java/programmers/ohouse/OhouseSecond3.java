package programmers.ohouse;

import java.util.ArrayList;
import java.util.List;

public class OhouseSecond3 {
    char[] charArray;

    public int solution(String str) {
        charArray = str.toCharArray();
        List<Integer> before = new ArrayList<>();
        List<Integer> after = new ArrayList<>();
        int hCount = 0;
        int oCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'h') {
                hCount++;
                if (canOAfter(i) != 0 && canOBefore(i) != 0) {
                    before.add(canOBefore(i));
                    after.add(canOAfter(i));
                }
            } else {
                oCount++;
            }
        }
        if (hCount == 0) {
            return 0;
        }
        return Math.min(Math.min(oCount / 2, hCount), Math.min(before.get(before.size() - 1), after.get(0)));
    }

    public int canOBefore(int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (charArray[i] == 'o') {
                count++;
            }
        }
        return count;
    }

    public int canOAfter(int index) {
        int count = 0;
        for (int i = index + 1; i < charArray.length; i++) {
            if (charArray[i] == 'o') {
                count++;
            }
        }
        return count;
    }
}
