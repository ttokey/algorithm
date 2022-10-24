package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import programmers.practice.WayToSchool;

class WayToSchoolTest {
    WayToSchool wayToSchool = new WayToSchool();

    @Test
    public void test() {

        //given
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};
        int expect = 4;

        //when
        int result = wayToSchool.solution(m, n, puddles);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}