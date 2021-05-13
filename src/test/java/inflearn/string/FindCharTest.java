package inflearn.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FindCharTest {
    private static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("Computercooler", 'c', 2),
                arguments("FreeFFF", 'F', 4),
                arguments("abc", 'd', 0)
        );
    }


    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String inputA, char inputB, int expect) {
        // given

        // when
        int result = FindChar.solution(inputA, inputB);

        // then
        assertThat(result).isEqualTo(expect);
    }
}
