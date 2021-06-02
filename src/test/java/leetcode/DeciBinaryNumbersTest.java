package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeciBinaryNumbersTest {
    public static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("32", 3),
                arguments("82734", 8),
                arguments("27346209830709182346", 9)
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String input, int expectOutput) {
        //given

        //when
        int resultOutput = DeciBinaryNumbers.solution(input);

        //then
        Assertions.assertThat(resultOutput).isEqualTo(expectOutput);
    }
}