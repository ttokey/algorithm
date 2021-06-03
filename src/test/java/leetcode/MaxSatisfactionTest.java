package leetcode;

import leetcode.hard.MaxSatisfaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class MaxSatisfactionTest {

    @Test
    public void test() {
        // given
        int[] input = {5, 3, 4, 2, 6};
        // when
        int[] result = Arrays.stream(input).sorted().toArray();
        ;
        // then
        Arrays.stream(result)
                .forEach(num -> System.out.println(num));
    }

    public static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.arguments(new int[]{-1, -8, 0, 5, -9}, 14),
                Arguments.arguments(new int[]{4, 3, 2}, 20),
                Arguments.arguments(new int[]{-1, -4, -5}, 0),
                Arguments.arguments(new int[]{-2, 5, -1, 0, 3, -3}, 35)
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(int[] input, int expect) {
        // given
        MaxSatisfaction maxSatisfaction = new MaxSatisfaction();
        // when
        int result = maxSatisfaction.maxSatisfaction(input);
        // then
        Assertions.assertThat(result).isEqualTo(expect);
    }
}