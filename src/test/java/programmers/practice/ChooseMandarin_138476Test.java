package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ChooseMandarin_138476Test {
    ChooseMandarin_138476 chooseMandarin_138476 = new ChooseMandarin_138476();

    @Test
    public void test() {
        //given
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int expect = 3;

        //when
        int result = chooseMandarin_138476.solution(k, tangerine);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}