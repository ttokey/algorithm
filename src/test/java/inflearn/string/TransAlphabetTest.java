package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TransAlphabetTest {

    public static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.arguments("a#b!GE*T@S", "S#T!EG*b@a"),
                Arguments.arguments("abcd", "dcba"),
                Arguments.arguments("ab$cde", "ed$cba")
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String input, String expect) {
        //given

        //when
        String result = TransAlphabet.solution(input);
        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}
