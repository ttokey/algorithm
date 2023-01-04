package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MakeBigNumber_42883Test {
    MakeBigNumber_42883 makeBigNumber_42883 = new MakeBigNumber_42883();

    @Test
    public void test() {
        //given
        String number = "1924";
        int k = 2;
        String expect = "94";
        //when
        String result = makeBigNumber_42883.solution(number, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        String number = "4321";
        int k = 1;
        String expect = "432";
        //when
        String result = makeBigNumber_42883.solution(number, k);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}