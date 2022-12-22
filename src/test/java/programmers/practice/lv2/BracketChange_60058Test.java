package programmers.practice.lv2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BracketChange_60058Test {
    BracketChange_60058 bracketChange_60058 = new BracketChange_60058();

    @Test
    public void test() {
        //given
        String p = "(()())()";
        String expect = "(()())()";

        //when
        String result = bracketChange_60058.solution(p);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void test2() {
        //given
        String p = "()))((()";
        String expect = "()(())()";

        //when
        String result = bracketChange_60058.solution(p);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}