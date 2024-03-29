package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RollCake_132265Test {
    RollCake_132265 rollCake_132265 = new RollCake_132265();

    @Test
    public void solution() {
        //given
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int expect = 2;

        //when
        int result = rollCake_132265.solution2(topping);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void solution2() {
        //given
        int[] topping = {1, 1, 1, 1, 1, 1};
        int expect = 5;

        //when
        int result = rollCake_132265.solution2(topping);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void solution3() {
        //given
        int[] topping = {1, 5, 5, 5, 5, 5};
        int expect = 1;

        //when
        int result = rollCake_132265.solution(topping);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}