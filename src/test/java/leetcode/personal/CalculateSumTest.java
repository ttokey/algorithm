package leetcode.personal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalculateSumTest {
    CalculateSum calculateSum = new CalculateSum();

    public static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3}, new int[]{3, 4, 5}, new int[]{4, 6, 8}),
                Arguments.arguments(new int[]{1, 4, 8, 9}, new int[]{2, 9, 1}, new int[]{1, 7, 8, 0}),
                Arguments.arguments(new int[]{9, 0, 4, 1}, new int[]{9, 9, 9}, new int[]{1, 0, 0, 4, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(int[] arr1, int[] arr2, int[] expect) {
        //given

        //when
        int[] result = calculateSum.calculateSum(arr1, arr2);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }

}