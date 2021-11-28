package programmers.lineFinance;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class lineFinanceFourthTest {

    lineFinanceFourth lineFinanceFourth = new lineFinanceFourth();

    @Test
    public void test() {
        int[][] input = {{0, 2, 1, 3}, {1, 2, 2, 5}, {3, 3, 4, 4}, {4, 1, 6, 3}, {1, 6, 5, 7}, {5, 5, 7, 6}, {5, 8, 6, 10}};
        String[] expect = {"0 0 1 1", "1 0 2 3", "2 0 3 1", "3 0 5 2", "0 3 4 4", "2 2 4 3", "4 3 5 5"};


        String[] result = lineFinanceFourth.solution(input);

        Assertions.assertThat(result).isEqualTo(expect);
    }
}