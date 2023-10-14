package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MissileSystem_181188Test {

    MissileSystem_181188 missileSystem181188 = new MissileSystem_181188();

    @Test
    public void test() {
        //given
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        int expect = 3;

        //when
        int result = missileSystem181188.solution(targets);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int[][] targets = {{-100, 100}, {50, 170}, {150, 200}, {-50, -10}, {10, 20}, {30, 40}};
        int expect = 4;

        //when
        int result = missileSystem181188.solution(targets);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}