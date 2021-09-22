package programmers.kakao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SixTest {
    Six six = new Six();

    @Test
    public void testSolution() {
        //given
        int[][] board = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
        int[][] skill = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
        int expectResult = 10;
        //when
        int result = six.solution(board, skill);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }
}