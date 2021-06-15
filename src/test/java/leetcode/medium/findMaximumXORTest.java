package leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class findMaximumXORTest {
    FindMaximumXOR findMaximumXOR = new FindMaximumXOR();

    public static Stream<Arguments> testCase() {
        return Stream.of(
                Arguments.arguments(new int[]{3, 10, 5, 25, 2, 8}, 28),
                Arguments.arguments(new int[]{0}, 0),
                Arguments.arguments(new int[]{2, 4}, 6),
                Arguments.arguments(new int[]{8, 10, 2}, 10),
                Arguments.arguments(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127)
        );
    }

    @ParameterizedTest
    @MethodSource("testCase")
    public void solution(int[] input, int expect) {
        //given

        //when
        int result = findMaximumXOR.findMaximumXOR(input);

        //then
        Assertions.assertThat(result).isEqualTo(expect);
    }


    @Test
    public void sumXOR() {
        //given

        int a = 5; // 10
        int b = 25; // 110
        int expect = 28;


        //when
        int result = findMaximumXOR.sumXOR(a, b);

        //then

//        System.out.println(a | b);
        System.out.println(result);
        Assertions.assertThat(result).isEqualTo(expect);
    }

    @Test
    public void getLength() {
        //given
        int a = 5;  //101
        int expect = 3;

        //when
        int result = findMaximumXOR.getLength(a);

        //then
        System.out.println(result);
        Assertions.assertThat(result).isEqualTo(expect);
    }

}