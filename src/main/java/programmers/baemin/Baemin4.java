package programmers.baemin;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Baemin4 {
    int count = 0;

    public int solution(String[] before, String[] after) {
        LinkedList<String> beforeList = new LinkedList<>();
        LinkedList<String> afterList = new LinkedList<>();
        for (int i = 0; i < before.length; i++) {
            if (!before[i].equals(after[i])) {
                beforeList.add(before[i]);
                afterList.add(after[i]);
            }
        }

        while (!beforeList.isEmpty()) {
            if (!canChange(beforeList, afterList)) {
                beforeList.set(0, "!");
                count++;
            }
        }

        return count;
    }

    public boolean canChange(LinkedList<String> before, LinkedList<String> after) {
        boolean result = false;
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < before.size(); i++) {
            String afterString = after.get(i);
            if (!before.contains(afterString) && before.indexOf(afterString) != i) {
                toRemove.add(i);
                count++;
                result = true;
            }
        }

        for (int i = toRemove.size() - 1; i >= 0; i--) {
            before.remove((int) toRemove.get(i));
            after.remove((int) toRemove.get(i));
        }
        return result;
    }
}
