package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LowerDistanceCharTest {

    public static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("aaaaaaaaa a", "0 0 0 0 0 0 0 0 0"),
                arguments("teachermode e", "1 0 1 2 1 0 1 2 2 1 0"),
                arguments("hi i", "1 0")

        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String input, String expect) {
        // given

        // when
        String result = LowerDistanceChar.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}