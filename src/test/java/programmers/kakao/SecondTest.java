package programmers.kakao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SecondTest {
    Second second = new Second();

    @Test
    public void testMakeNum() {
        //given
        int n = 437674;
        int k = 3;
        String expectResult = "211020101011";

        //when
        String result = second.makeNum(n, k);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }

    @Test
    public void testSolution() {
        //given
        int n = 437674;
        int k = 3;
        int expectResult = 3;

        //when
        int result = second.solution(n, k);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }
}