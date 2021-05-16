package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PalindromeStringTest {
    @Test
    public void solution() {
        //given
        String input = "gooG";
        String expect = "YES";
        //when
        String result = PalindromeString.solution(input);
        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}