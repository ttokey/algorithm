package programmers.baemin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Baemin4Test {
    Baemin4 baemin4 = new Baemin4();

    @Test
    public void test() {
        //given
        String[] before = {"A", "B", "C", "D"};
        String[] after = {"E", "F", "G", "H"};
        int expect = 4;

        //when
        int result = baemin4.solution(before, after);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}