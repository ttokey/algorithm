package programmers.devMatching;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Dotted_140107Test {
    Dotted_140107 dotted_140107 = new Dotted_140107();

    @Test
    public void test() {
        //given
        int k = 2;
        int d = 4;
        long expect = 6;

        //when
        long result = dotted_140107.solution(k, d);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}