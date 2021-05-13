package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TransCharTest {
    public static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("StuDY", "sTUdy"),
                arguments("SeokHeeLee", "sEOKhEElEE"),
                arguments("", "")
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String input, String expectOutput) {
        // given


        // when
        String resultOutput = TransChar.solution(input);

        // then
        Assertions.assertThat(resultOutput).isEqualTo(expectOutput);
    }
}
