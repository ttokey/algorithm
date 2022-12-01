package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PathOfLight_86052Test {
    PathOfLight_86052 pathOfLight_86052 = new PathOfLight_86052();

    @Test
    public void test() {
        //given
        String[] grid = {"SL", "LR"};
        int[] expect = {16};

        //when
        int[] result = pathOfLight_86052.solution(grid);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        String[] grid = {"S"};
        int[] expect = {1, 1, 1, 1};

        //when
        int[] result = pathOfLight_86052.solution(grid);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }


    @Test
    public void test3() {
        //given
        String[] grid = {"R", "R"};
        int[] expect = {4, 4};

        //when
        int[] result = pathOfLight_86052.solution(grid);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}