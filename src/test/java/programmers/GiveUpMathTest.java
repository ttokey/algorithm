package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import programmers.practice.GiveUpMath;

class GiveUpMathTest {
    GiveUpMath giveUpMath = new GiveUpMath();

    @Test
    public void test() {
        //given
        int[] answers = {1, 3, 2, 4, 2};
        int[] expectResult = {1, 2, 3};
        //when
        int[] result = giveUpMath.solution(answers);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);
    }
}