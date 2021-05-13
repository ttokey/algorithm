package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindWordInStringTest {

    public static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("it is time to study", "study"),
                arguments("Hi my name is SeokheeLee", "SeokheeLee")
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String input, String expect) {
        // given

        // when
        String result = FindWordInString.solution(input);

        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}
