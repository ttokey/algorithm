package programmers.jetbrain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JetBrain3Test {
    JetBrain3 jetBrain3 = new JetBrain3();

    @Test
    public void test() {
        //given

        int[][] queries = {{3, 1}, {2, 2}, {1, 1}, {2, 3}, {0, 1}, {2, 1}};
        long expect = 2;

        //when
        long result = jetBrain3.solution(2, 5, 0, 1, queries);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given

        int[][] queries = {{2, 1}, {0, 1}, {1, 1}, {0, 1}, {2, 1}};
        long expect = 2;

        //when
        long result = jetBrain3.solution(2, 2, 0, 0, queries);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}