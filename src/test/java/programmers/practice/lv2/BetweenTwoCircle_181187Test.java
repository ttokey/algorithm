package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BetweenTwoCircle_181187Test {
    BetweenTwoCircle_181187 betweenTwoCircle181187 = new BetweenTwoCircle_181187();

    @Test
    public void test() {
        //given
        int r1 = 2;
        int r2 = 3;
        long expect = 20;

        //when
        long result = betweenTwoCircle181187.solution(r1, r2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}