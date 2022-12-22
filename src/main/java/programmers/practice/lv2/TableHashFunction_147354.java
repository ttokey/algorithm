package programmers.practice.lv2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TableHashFunction_147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<List<Integer>> dataList = Arrays.stream(data)
                .sorted((a, b) -> compare(a, b, col))
                .map(arr -> Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        int answer = 0;
        for (int i = row_begin - 1; i < row_end; i++) {
            answer = answer ^ hash(dataList.get(i), i + 1);
        }
        return answer;
    }

    public int hash(List<Integer> tuple, int index) {
        int result = 0;
        for (Integer num : tuple) {
            result += num % index;
        }
        return result;
    }

    public int compare(int[] a, int[] b, int col) {
        if (a[col - 1] == b[col - 1]) {
            return b[0] - a[0];
        }
        return a[col - 1] - b[col - 1];
    }
}
