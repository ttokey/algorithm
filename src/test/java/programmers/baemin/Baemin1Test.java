package programmers.baemin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Baemin1Test {
    Baemin1 baemin1 = new Baemin1();

    @Test
    public void test() {
        //given
        String input = "ABCDEF";
        String expect = "DEBFCA";

        //when
        String result = baemin1.solution(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}