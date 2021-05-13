package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReverseWordTest {
    @Test
    public void solution() {
        // given
        List<String> input = Arrays.asList("good", "Time", "Big");
        List<String> expectOutput = Arrays.asList("doog", "emiT", "giB");

        // when
        List<String> resultOutput = ReverseWord.solution(input);

        // then
        Assertions.assertThat(resultOutput).isEqualTo(expectOutput);
    }
}
