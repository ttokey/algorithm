package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Tired_87946Test {
    Tired_87946 tired_87946 = new Tired_87946();

    @Test
    public void test() {
        //given
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int expect = 3;

        //when
        int result = tired_87946.solution(k, dungeons);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}