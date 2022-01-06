package programmers.skillCheck;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Level2_1Test {
    Level2_1 level2_1 = new Level2_1();

    @Test
    public void test() {
        int[] A = {1, 2};
        int[] B = {3, 4};
        int expect = 10;

        int result = level2_1.solution(A, B);

        Assertions.assertThat(result).isEqualTo(expect);
    }

}