package programmers.kakao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class SevenTest {
    Seven seven = new Seven();

    @Test
    public void testSolution() {
        //given
        int[][] visited = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[] aloc = {1, 0};
        int[] bloc = {1, 2};
        int expectResult = 5;
        //when
        int result = seven.solution(visited, aloc, bloc);

        //then
        Assertions.assertThat(result).isEqualTo(expectResult);

    }

}