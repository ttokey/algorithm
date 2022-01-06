package programmers.skillCheck;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Level2_4Test {
    Level2_4 level2_4 = new Level2_4();

    @Test
    public void test() {
        String numbers = "17";
        int expect = 3;

        int result = level2_4.solution(numbers);

        Assertions.assertThat(result).isEqualTo(expect);

    }


}