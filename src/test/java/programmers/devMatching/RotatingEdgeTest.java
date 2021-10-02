package programmers.devMatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RotatingEdgeTest {
    RotatingEdge rotatingEdge = new RotatingEdge();

    @Test
    public void testRotatingEdge() {
        //given
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] expect = {8, 10, 25};

        //when
        int[] result = rotatingEdge.solution(rows, columns, queries);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}