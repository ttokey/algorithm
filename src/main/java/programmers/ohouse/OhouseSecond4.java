package programmers.ohouse;

import java.util.ArrayList;
import java.util.List;

public class OhouseSecond4 {
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

        int count = 0;
        for (int i = 0; i < before.size() / 2; i++) {
            if (before.get(i) >= i + 1) {
                count++;
            }
            if (after.get(before.size() - i - 1) >= i + 1) {
                count++;
            }
        }


        return Math.min(Math.min(oCount / 2, hCount), count);
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
