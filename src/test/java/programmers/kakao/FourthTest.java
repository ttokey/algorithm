package programmers.kakao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FourthTest {
    Fourth fourth = new Fourth();

    @Test
    public void testSolution() {
        //given
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] expectResult = {1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0};

        //when
        int[] result = fourth.solution(n, info);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }

}