package programmers.practice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NightTacticalWalking_133501Test {
    NightTacticalWalking_133501 nightTacticalWalking_133501 = new NightTacticalWalking_133501();

    @Test
    public void solution() {
        //given
        int distance = 10;
        int[][] scope = {{3, 4}, {5, 8}};
        int[][] times = {{2, 5}, {4, 3}};
        int expect = 8;

        //when
        int result = nightTacticalWalking_133501.solution(distance, scope, times);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}