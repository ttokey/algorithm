package programmers.naverpay;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NPSecondTest {
    NPSecond npSecond = new NPSecond();

    @Test
    public void test() {
        int n = 5;
        int jump = 3;
        int[] expect = {5, 2};

        int[] result = npSecond.solution(n, jump);

        Assertions.assertThat(expect).isEqualTo(result);
    }


    NPFourth npFourth = new NPFourth();

    @Test
    public void test2() {
        int n = 5;
        int jump = 3;
        int[] expect = {5, 2};

        int[][] input = {{-10, 20, 30}, {-10, 0, 10}, {-20, 40, 1}};

        int result = npFourth.solution(input);

        Assertions.assertThat(expect).isEqualTo(result);
    }
}