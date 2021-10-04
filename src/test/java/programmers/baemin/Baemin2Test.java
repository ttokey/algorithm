package programmers.baemin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Baemin2Test {
    Baemin2 baemin2 = new Baemin2();

    @Test
    public void testMakeMap() {
        //given
        int n = 4;


        //when
        int[][] result = baemin2.makeMap(n);

        //then
        System.out.println(result);

    }

    @Test
    public void test() {
        int n = 3;
        int[] expect = {1, 12, 2, 11, 13, 3, 18, 14, 10, 19, 4, 17, 15, 9, 16, 5, 8, 6, 7};

        int[] result = baemin2.solution(n);

        Assertions.assertThat(result).isEqualTo(expect);
    }
}