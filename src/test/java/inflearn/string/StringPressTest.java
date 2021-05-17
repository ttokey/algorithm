package inflearn.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringPressTest {

    public static Stream<Arguments> testCase() {
        return Stream.of(
                arguments("KKHSSSSSSSE", "K2HS7E"),
                arguments("KSTTTSEEKFKKKDJJGG", "KST3SE2KFK3DJ2G2")
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(String input, String expect) {
        // given

        // when
        String result = StringPress.solution(input);
        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}