package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidPalindromeTest {

    @Test
    public void solution() {
        // given
        String input = "found7, time: study; Yduts; emit, 7Dnuof";
        String expect = "YES";
        // when
        String result = ValidPalindrome.solution(input);
        // then
        Assertions.assertThat(result).isEqualTo(expect);

    }

}