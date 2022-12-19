package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxExpression_67257Test {
    MaxExpression_67257 maxExpression_67257 = new MaxExpression_67257();

    @Test
    public void test() {
        //given
        String input = "100-200*300-500+20";
        long expect = 60420;

        //when
        long result = maxExpression_67257.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}