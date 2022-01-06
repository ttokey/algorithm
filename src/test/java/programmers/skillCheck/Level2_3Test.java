package programmers.skillCheck;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Level2_3Test {
    Level2_3 level2_3 = new Level2_3();

    @Test
    public void test() {
        int[] citations = {3, 0, 6, 1, 5};
        int expect = 3;

        int result = level2_3.solution(citations);

        Assertions.assertThat(result).isEqualTo(expect);
    }

}