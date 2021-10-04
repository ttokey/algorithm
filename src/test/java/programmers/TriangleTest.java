package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TriangleTest {
    Triangle triangle = new Triangle();

    @Test
    public void test() {
        //given
        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int expect = 30;

        //when
        int result = triangle.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}