package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JoyStick_42860Test {
    JoyStick_42860 joyStick_42860 = new JoyStick_42860();

    @Test
    public void test() {
        //given
        String name = "JEROEN";
        int expect = 56;

        //when
        int result = joyStick_42860.solution(name);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

    @Test
    public void test2() {
        //given
        String name = "BBBBAAAABA";
        int expect = 12;

        //when
        int result = joyStick_42860.solution(name);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}