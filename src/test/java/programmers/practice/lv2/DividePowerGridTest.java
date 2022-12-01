package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DividePowerGridTest {
    DividePowerGrid dividePowerGrid = new DividePowerGrid();

    @Test
    public void test() {
        //given
        int n = 4;
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        int expect = 0;
        //when
        int result = dividePowerGrid.solution(n, wires);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int expect = 3;
        //when
        int result = dividePowerGrid.solution(n, wires);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}