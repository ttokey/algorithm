package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetNumberTest {

    @Test
    public void solution() {
        // given
        String input = "g0en2T0s8eSoft";
        int expect = 208;
        // when
        int result = GetNumber.solution(input);
        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}