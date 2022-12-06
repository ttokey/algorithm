package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetDistance_81302Test {
    GetDistance_81302 getDistance_81302 = new GetDistance_81302();

    @Test
    public void test() {
        //given
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] expect = {1, 0, 1, 1, 1};
        //when
        int[] result = getDistance_81302.solution(places);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}