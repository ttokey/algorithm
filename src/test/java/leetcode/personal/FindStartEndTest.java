package leetcode.personal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class FindStartEndTest {
    FindStartEnd findStartEnd = new FindStartEnd();

    public static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(1, 2, 5, 8, 8, 8, 8, 8, 8, 9, 10), 8, new int[]{3, 8}),
                Arguments.arguments(Arrays.asList(1, 4, 5, 6, 9, 11, 12), 5, new int[]{2, 2}),
                Arguments.arguments(Arrays.asList(), 8, new int[]{-1, -1}),
                Arguments.arguments(Arrays.asList(1, 2, 3, 4), 5, new int[]{-1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(List<Integer> arr, int target, int[] expect) {
        //given

        //when
        int[] result = findStartEnd.findStartEnd(arr, target);
        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }


}