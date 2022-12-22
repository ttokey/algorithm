package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TableHashFunction_147354Test {
    TableHashFunction_147354 tableHashFunction_147354 = new TableHashFunction_147354();

    @Test
    public void test() {
        //given
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int expect = 4;

        //when
        int result = tableHashFunction_147354.solution(data, col, row_begin, row_end);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}