package programmers.ohouse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OhouseSecond5 {
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
        while (isCanCount(before, after)) {
            count++;
            before = minusList(before);
            after = minusList(after);
        }
        return Math.min(Math.min(oCount / 2, hCount), count);
    }

    public List<Integer> minusList(List<Integer> input) {
        return input.stream().map(i -> i - 1).collect(Collectors.toList());
    }

    public boolean isCanCount(List<Integer> before, List<Integer> after) {
        if (before.isEmpty()) {
            return false;
        }
        for (int i = 0; i < before.size(); i++) {
            if (before.get(i) > 0 && after.get(i) > 0) {
                return true;
            }
        }
        return false;
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
