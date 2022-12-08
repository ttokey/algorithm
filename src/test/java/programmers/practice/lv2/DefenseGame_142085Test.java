package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DefenseGame_142085Test {
    DefenseGame_142085 defenseGame_142085 = new DefenseGame_142085();

    @Test
    public void test() {
        //given
        int n = 7;
        int k = 3;
        int[] enemies = {4, 2, 4, 5, 3, 3, 1};
        int expect = 5;

        //when
        int result = defenseGame_142085.solution(n, k, enemies);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        int n = 2;
        int k = 4;
        int[] enemies = {3, 3, 3, 3};
        int expect = 4;

        //when
        int result = defenseGame_142085.solution(n, k, enemies);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}