package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordTest {
    @Test
    public void solution() {
        // given
        int numberOf = 4;
        String input = "#****###**#####**#####**##**";
        String expect = "COOL";
        // when
        String result = Password.solution(numberOf, input);
        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}