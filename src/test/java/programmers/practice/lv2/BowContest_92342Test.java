package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BowContest_92342Test {
    BowContest_92342 bowContest_92342 = new BowContest_92342();

    @Test
    public void test() {
        //given
        int n = 5;
        int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        int[] expect = {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0};
        //when
        int[] result = bowContest_92342.solution(n, info);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        int n = 9;
        int[] info = {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1};
        int[] expect = {1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0};
        //when
        int[] result = bowContest_92342.solution(n, info);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test3() {
        //given
        int n = 10;
        int[] info = {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        int[] expect = {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2};
        //when
        int[] result = bowContest_92342.solution(n, info);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test4() {
        //given
        int n = 1;
        int[] info = {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] expect = {-1};
        //when
        int[] result = bowContest_92342.solution(n, info);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }
}