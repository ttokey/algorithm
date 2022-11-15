package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsecutiveNumberSubSequence_131701Test {
    ConsecutiveNumberSubSequence_131701 consecutiveNumberSubSequence_131701 = new ConsecutiveNumberSubSequence_131701();

    @Test
    public void test() {
        //given
        int[] input = {7, 9, 1, 1, 4};
        int expect = 18;

        //when
        int result = consecutiveNumberSubSequence_131701.solution(input);


        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}