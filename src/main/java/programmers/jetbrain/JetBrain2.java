package programmers.jetbrain;

import java.util.ArrayList;
import java.util.List;

public class JetBrain2 {
    List<Long> list = new ArrayList<>();

    public int[] solution(int n, long left, long right) {
        long startRow = left / n;
        long endRow = right / n;

        if (startRow == endRow) {
            addList(startRow, left % n, right % n);
        } else {
            addList(startRow, left % n, n - 1);
            for (long i = startRow + 1; i < endRow; i++) {
                addList(i, 0, n - 1);
            }
            addList(endRow, 0, right % n);
        }
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }

    public void addList(long row, long start, long end) {
        for (long i = start; i <= end; i++) {
            list.add(Math.max(i + 1, row + 1));
        }
    }


}
