package programmers.ohouse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OhouseFirstTest {
    OhouseFirst ohouseFirst = new OhouseFirst();

    @Test
    public void test() {
        //given
        int N = 4;
        int[] height = {3, 3, 3, 3};
        long expect = 3;

        //when
        long result = ohouseFirst.solution3(N, height);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}