package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RotateBracket_76502Test {
    RotateBracket_76502 rotateBracket_76502 = new RotateBracket_76502();

    @Test
    public void test() {
        //given
        String s = "}]()[{";
        int expect = 2;

        //when
        int result = rotateBracket_76502.solution(s);

        //then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}