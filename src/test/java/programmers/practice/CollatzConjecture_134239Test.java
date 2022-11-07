package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CollatzConjecture_134239Test {
    CollatzConjecture_134239 collatzConjecture_134239 = new CollatzConjecture_134239();

    @Test
    public void solition() {
        //given
        int k = 5;
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        double[] expect = {33.0, 31.5, 0.0, -1.0};

        //when
        double[] result = collatzConjecture_134239.solution(k, ranges);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}